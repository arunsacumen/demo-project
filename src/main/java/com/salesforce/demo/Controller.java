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
    public boolean getHelloWorld() throws IOException {
        boolean result=false;
        System.out.println("getHelloWorld method called");
       String s= interfaceGenerice.getAccessToken("getAccess_token");
        if (s.equals(Constants.accessToken)) {
            result=true;
        }


        return result;
    }
    @GetMapping("/getAccessToken")
    public String getAccessToken(String passed) throws IOException {
        System.out.println("Controller class executrd");
        String actual=interfaceGenerice.getAccessToken("getAccess_token");
        if(actual.equals(passed)){
            return actual;
        }
        return "Access token is wrong";


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
