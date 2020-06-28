package com.ernesto.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.bl.MovieBl;
import com.ernesto.backend.bl.WarehouseBI;
import com.ernesto.backend.model.MovieModel;
import com.ernesto.backend.model.WarehouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/warehouse")
@CrossOrigin(origins = "*")
public class WarehouseController {

    private WarehouseBI warehouseBI;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public WarehouseController(WarehouseBI warehouseBI) { this.warehouseBI = warehouseBI; }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<WarehouseModel>> selectAllWarehouses(@RequestHeader("Authorization") String authorization){
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
        return new ResponseEntity<>(this.warehouseBI.selectAllWarehouses(), HttpStatus.OK);
    }
}
