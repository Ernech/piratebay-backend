package com.ernesto.backend;

import ch.qos.logback.core.net.server.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
        @RequestMapping(
                method = RequestMethod.POST,
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<ClientDto> helloWorld(ClientDto clientDto){
            System.out.println(clientDto);
            clientDto.setBirthDate(new Date());
            return new ResponseEntity<ClientDto>(clientDto, HttpStatus.OK);

    }
}
