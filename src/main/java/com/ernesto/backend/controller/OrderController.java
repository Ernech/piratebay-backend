package com.ernesto.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.bl.KardexBl;
import com.ernesto.backend.bl.OrderBl;
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
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderBl orderBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public OrderController(OrderBl orderBl) { this.orderBl = orderBl; }

    @RequestMapping(
            path = "/{warehouseId}/not_entry/{productId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<OrderModel>> returnOrdersByMovie (@RequestHeader("Authorization") String authorization,
                                                                      @PathVariable("warehouseId") Integer warehouseId,
                                                                      @PathVariable("productId") Integer productId){

        OrderParameterModel orderParameterModel = new OrderParameterModel();
        orderParameterModel.setWarehouseId(warehouseId);
        orderParameterModel.setProductId(productId);

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
        return new ResponseEntity<>(this.orderBl.returnNotReceivedOrders(orderParameterModel.getWarehouseId(), orderParameterModel.getProductId()), HttpStatus.OK);
    }
}
