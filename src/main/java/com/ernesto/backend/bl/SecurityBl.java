package com.ernesto.backend.bl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.dao.UserDao;
import com.ernesto.backend.model.TokenRefreshModel;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityBl {
    private UserDao userDao;

    @Value("${piratebay.security.salt}")
    private String salt;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
    Este metodo recibe el usuario y password en plano, consulta a la base de datos, enviando el password con
    * SHA256 + SALT, y si esta bien genera el token JWT
    * @param username Nombre de usuario en plano
    * @param password Contraseña en plano
    * @return Token JWT.
    */
    public Map<String,String> authenticate(String username, String password){
        Map<String,String> result = new HashMap<>();
        String sha256hex= Hashing.sha256()
                .hashString(password+salt, StandardCharsets.UTF_8)
                .toString();//TODO repetir el algoritmo hash n veces
       // System.out.println("Password "+ sha256hex);
        Integer userId=userDao.findUserIdByUsernameAndPassword(username,sha256hex);
        if(userId!=null){
            result.put("authentication",generateJwt(userId,2,"AUTHN",userDao.findAllFeatureCodeByUserId(userId)));
            result.put("refresh", generateJwt(userId, 6, "REFRESH",null));
            return result;
        }else{
            return null;
        }
    }

    public Map <String,String> refresh(TokenRefreshModel tokenRefreshModel){
        String tokenJwt = tokenRefreshModel.getRefreshModel();
        DecodedJWT decodedJWT = JWT.decode(tokenJwt);
        String idUsuario = decodedJWT.getSubject();
        if(!"REFRESH".equals(decodedJWT.getClaim("type").asString())){
            throw new RuntimeException("El token prporcionado no es un token válido para actualizar");
        }
        //El siguiente código valida si el token es bueno y además si es un token de autenticación

            Algorithm algorithm = Algorithm.HMAC256(secretJwt);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("PirateBay")
                    .build();
            verifier.verify(tokenJwt);
        Map<String,String> result = new HashMap<>();
        Integer userIdAsInt = Integer.parseInt(idUsuario);
        result.put("authentication",generateJwt(Integer.parseInt(idUsuario),2,"AUTHN",userDao.findAllFeatureCodeByUserId(userIdAsInt)));
        result.put("refresh",generateJwt(Integer.parseInt(idUsuario),6,"REFRESH",null));
        return result;
    }
    private String generateJwt(int userId, int minutes, String type, ArrayList<String> features){
        LocalDateTime expiresAt = LocalDateTime.now(ZoneId.systemDefault()).plusMinutes(minutes);
        String token =null;
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretJwt);
            if(features!=null){
                token = JWT.create()
                        .withIssuer("PirateBay")
                        .withClaim("type",type)
                        .withArrayClaim("features",features.toArray(new String[0]))
                        .withSubject(Integer.toString(userId))
                        .withExpiresAt(Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant()))
                        .sign(algorithm);

            }else{
               token = JWT.create()
                        .withIssuer("PirateBay")
                        .withClaim("type",type)
                        .withSubject(Integer.toString(userId))
                        .withExpiresAt(Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant()))
                        .sign(algorithm);
            }

        }catch (JWTCreationException exception){
            throw new RuntimeException(exception);
        }
        return token;
    }
}
