package com.salesforce.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/salesforce")
public class Controller {

    @Autowired
    InterfaceGenerice interfaceGenerice;

    @GetMapping("/hello")
    public String getHelloWorld() throws IOException {
        return "hello world";
    }
    @GetMapping("/getAccessToken")
    public String getAccessToken() throws IOException {
        return interfaceGenerice.getAccessToken("getAccess_token");
    }

    @PostMapping("/postCall")
    public String postCall() throws IOException {
        return interfaceGenerice.getAccessToken(" ");
    }

    @GetMapping("/getEventLogFile")
    public String getEventLogFile() throws IOException {
        return interfaceGenerice.getEventLogFile();
    }
}

