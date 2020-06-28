package com.ernesto.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.bl.MovieBl;
import com.ernesto.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private MovieBl movieBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public MovieController(MovieBl movieBl) { this.movieBl = movieBl; }

    // Método para obtener todas las películas de un almacén
    @RequestMapping(
            method = RequestMethod.POST,
            consumes =MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<MovieModel>> selectMoviesFromWarehouse(@RequestHeader("Authorization") String authorization, @RequestBody WarehouseModel warehouseModel){
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
        return new ResponseEntity<>(this.movieBl.selectMoviesFromWarehouse(warehouseModel.getWarehouseId()), HttpStatus.OK);
    }

    // Método para buscar películas por su nombre UNICAMENTE EN LA BARRA DE BÚSQUEDA
    @RequestMapping(
            value = "search",
            method = RequestMethod.POST,
            consumes =MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<MovieModel>> searchMoviesByName (@RequestHeader("Authorization") String authorization, @RequestBody SearchParameterModel searchParameterModel){
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
        return new ResponseEntity<>(this.movieBl.searchMoviesByName(searchParameterModel.getWarehouseId(), searchParameterModel.getSearchParameter()), HttpStatus.OK);
    }

    // Buscar una lista de películas y ordenarlas

    @RequestMapping(
            value = "search/sort",
            method = RequestMethod.POST,
            consumes =MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<MovieModel>> searchAndSortMovies (@RequestHeader("Authorization") String authorization, @RequestBody SearchSortParameterModel searchSortParameterModel){
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
        return new ResponseEntity<>(this.movieBl.searchAndSortMovies(searchSortParameterModel.getWarehouseId(), searchSortParameterModel.getSearchParameter(), searchSortParameterModel.getSortParameter()), HttpStatus.OK);
    }

    // Ordenar por un criterio la lista de películas

    @RequestMapping(
            value = "sort",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<MovieModel>> sortMoviesByParameter (@RequestHeader("Authorization") String authorization, @RequestBody SortParameterModel sortParameterModel){
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
        return new ResponseEntity<>(this.movieBl.sortMoviesByParameter(sortParameterModel.getWarehouseId(), sortParameterModel.getSortParameter()), HttpStatus.OK);
    }
}
