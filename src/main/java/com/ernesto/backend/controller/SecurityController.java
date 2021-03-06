package com.ernesto.backend.controller;

import com.ernesto.backend.bl.SecurityBl;
import com.ernesto.backend.model.CredentialModel;
import com.ernesto.backend.model.TokenRefreshModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("api/v1/security")

public class SecurityController {

    private SecurityBl securityBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public SecurityController(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

    @RequestMapping(
            value="login",
            method = RequestMethod.POST,
            produces =  MediaType.APPLICATION_JSON_VALUE,
            consumes =MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Map<String,Object>>authenticate(@RequestBody CredentialModel credentialModel){
        //Integer userId = securityBl.authenticate(credentialModel.getUsername(),credentialModel.getPassword());
        Map <String,String> tokens = securityBl.authenticate(credentialModel.getUsername(),credentialModel.getPassword());
        if(tokens!=null){
            Map <String,Object> response = new HashMap();
            response.put("Message","Authentication OK");
            response.put("authentication",tokens.get("authentication"));
            response.put("refresh",tokens.get("refresh"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            Map <String,Object> response = new HashMap();
            response.put("Message","User or password invalid");
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "refresh",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>>authenticate(@RequestBody TokenRefreshModel tokenRefreshModel){
        System.out.println("Token refresh " + tokenRefreshModel.getRefreshModel());
        Map<String,String> tokens = securityBl.refresh(tokenRefreshModel);
        Map<String,String> response= new HashMap<>();
        response.put("Message","Authentication OK");
        response.put("authentication", tokens.get("authentication"));
        response.put("refresh", tokens.get("refresh"));
        return new ResponseEntity (response, HttpStatus.OK);

    }
}
