package com.ernesto.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.bl.KardexBl;
import com.ernesto.backend.bl.MovieBl;
import com.ernesto.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/kardex")
@CrossOrigin(origins = "*")
public class KardexController {

    private KardexBl kardexBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public KardexController(KardexBl kardexBl) { this.kardexBl = kardexBl; }

    @RequestMapping(
            value = "information",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<KardexInformationModel> returnKardexInformationByMovie (@RequestHeader("Authorization") String authorization, @RequestBody KardexParameterModel kardexParameterModel){
        //Decodificando el token
        String tokenJwt = authorization.substring(7);
        DecodedJWT decodedJWT = JWT.decode(tokenJwt);
        String idUsuario = decodedJWT.getSubject();
        //Validando si el token es bueno y de autenticación
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString())){
            throw new RuntimeException("El token proporcionado no es un token de autenticación");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("PirateBay").build();
        verifier.verify(tokenJwt);
        return new ResponseEntity<>(this.kardexBl.returnKardexInformationByMovie(kardexParameterModel.getWarehouseId(), kardexParameterModel.getProductId()), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<KardexModel>> returnKardexByMovie (@RequestHeader("Authorization") String authorization, @RequestBody KardexParameterModel kardexParameterModel){
        //Decodificando el token
        String tokenJwt = authorization.substring(7);
        DecodedJWT decodedJWT = JWT.decode(tokenJwt);
        String idUsuario = decodedJWT.getSubject();
        //Validando si el token es bueno y de autenticación
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString())){
            throw new RuntimeException("El token proporcionado no es un token de autenticación");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("PirateBay").build();
        verifier.verify(tokenJwt);
        return new ResponseEntity<>(this.kardexBl.returnKardexByMovie(kardexParameterModel.getWarehouseId(), kardexParameterModel.getProductId()), HttpStatus.OK);
    }

    @RequestMapping(
            value = "update",
            method = RequestMethod.PUT,
            produces =  MediaType.APPLICATION_JSON_VALUE,
            consumes =MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity <Map<String,String>> updateQttyReceivedByMovie (@RequestHeader("Authorization") String authorization, @RequestBody UpdateQttyModel updateQttyModel){
        //Decodificando el token
        String tokenJwt = authorization.substring(7);
        DecodedJWT decodedJWT = JWT.decode(tokenJwt);
        String idUsuario = decodedJWT.getSubject();
        //Validando si el token es bueno y de autenticación
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString())){
            throw new RuntimeException("El token proporcionado no es un token de autenticación");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("PirateBay").build();
        verifier.verify(tokenJwt);

        Boolean updated = kardexBl.updateQttyReceivedByMovie(updateQttyModel.getQttyReceived(), updateQttyModel.getProviderProductId());
        Map <String, String> response = new HashMap();
        if(updated == true){
            response.put("Message","Updated ok");
        }
        else{
            response.put("Message","Not updated");
        }

        if(updated == true)
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

    }
}

