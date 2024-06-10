package com.example.BES.controller;

import com.example.BES.client.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/bes")
public class BESController {

    @Autowired
    private SoapClient soapClient;
    @GetMapping("/test")
    public String test() {
        return "Java";
    }

    @GetMapping("/pwd")
    public ResponseEntity<?> getPassword() throws JAXBException {
        return ResponseEntity.ok(soapClient.getPassword());
    }
}
