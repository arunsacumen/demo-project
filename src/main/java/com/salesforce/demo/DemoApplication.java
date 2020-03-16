package com.salesforce.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("Arun--------------->");
        /*InterfaceGenerice interfaceGenerice=new InterfaceGenericeimpl();
        interfaceGenerice.getAccessToken("getAccess_token");
        System.out.println("My output  "+interfaceGenerice.getAccessToken("getAccess_token"));*/
        SpringApplication.run(DemoApplication.class, args);

    }

}
