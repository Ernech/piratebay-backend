package com.ernesto.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.bl.MovieBl;
import com.ernesto.backend.bl.SecurityBl;
import com.ernesto.backend.bl.UserBl;
import com.ernesto.backend.model.MovieModel;
import com.ernesto.backend.model.UserModel;
import com.ernesto.backend.model.WarehouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private MovieBl movieBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public MovieController(MovieBl movieBl) { this.movieBl = movieBl; }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes =MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<MovieModel>> selectMoviesFromWarehouse(@RequestHeader("Authorization") String authorization, @RequestBody WarehouseModel warehouseModel){
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

        return new ResponseEntity<>(this.movieBl.selectMoviesFromWarehouse(warehouseModel.getWarehouse()), HttpStatus.OK);
    }

}
