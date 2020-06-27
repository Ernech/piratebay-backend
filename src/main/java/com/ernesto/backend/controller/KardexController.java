package com.ernesto.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.bl.KardexBl;
import com.ernesto.backend.bl.MovieBl;
import com.ernesto.backend.model.KardexInformationModel;
import com.ernesto.backend.model.KardexModel;
import com.ernesto.backend.model.MovieModel;
import com.ernesto.backend.model.ParameterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<KardexInformationModel>> returnKardexInformationByMovie (@RequestHeader("Authorization") String authorization, @RequestBody ParameterModel parameterModel){
        //Decodificando el token
        String tokenJwt = authorization.substring(7);
        System.out.println("TOKEN JWT: "+   tokenJwt);
        DecodedJWT decodedJWT = JWT.decode(tokenJwt);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USER: "+idUsuario);
        //Validando si el token es bueno y de autenticación
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString())){
            throw new RuntimeException("El token proporcionado no es un token de autenticación");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("PirateBay").build();
        verifier.verify(tokenJwt);
        return new ResponseEntity<>(this.kardexBl.returnKardexInformationByMovie(parameterModel.getWarehouse(), parameterModel.getParameter()), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<KardexModel>> returnKardexModelByMovie (@RequestHeader("Authorization") String authorization, @RequestBody ParameterModel parameterModel){
        //Decodificando el token
        String tokenJwt = authorization.substring(7);
        System.out.println("TOKEN JWT: "+   tokenJwt);
        DecodedJWT decodedJWT = JWT.decode(tokenJwt);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USER: "+idUsuario);
        //Validando si el token es bueno y de autenticación
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString())){
            throw new RuntimeException("El token proporcionado no es un token de autenticación");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("PirateBay").build();
        verifier.verify(tokenJwt);
        return new ResponseEntity<>(this.kardexBl.returnKardexModelByMovie(parameterModel.getWarehouse(), parameterModel.getParameter()), HttpStatus.OK);
    }
}
