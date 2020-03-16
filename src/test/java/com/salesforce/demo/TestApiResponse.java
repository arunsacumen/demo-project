package com.salesforce.demo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TestApiResponse  {
    String logResponse="{\"objectDescribe\":{\"activateable\":false,\"createable\":false,\"custom\":false,\"customSetting\":false,\"deletable\":false,\"deprecatedAndHidden\":false,\"feedEnabled\":false,\"keyPrefix\":\"0AT\",\"label\":\"Event Log File\",\"labelPlural\":\"Event Log Files\",\"layoutable\":false,\"mergeable\":false,\"name\":\"EventLogFile\",\"queryable\":true,\"replicateable\":false,\"retrieveable\":true,\"searchable\":false,\"triggerable\":false,\"undeletable\":false,\"updateable\":false,\"urls\":{\"rowTemplate\":\"/services/data/v32.0/sobjects/EventLogFile/{ID}\",\"describe\":\"/services/data/v32.0/sobjects/EventLogFile/describe\",\"sobject\":\"/services/data/v32.0/sobjects/EventLogFile\"}},\"recentItems\":[]}";
    @InjectMocks
    Controller controller;
   @Mock
    InterfaceGenerice interfaceGenerice;
    @Rule
   public MockitoRule mockitoRule= MockitoJUnit.rule();

    @Test

    public void hello() throws IOException {
       when(interfaceGenerice.getAccessToken("getAccess_token")).thenReturn(Constants.accessToken);
       boolean value=controller.getHelloWorld();
       assertEquals(true,value);


    }
    @Test
    public void ControllerTtest_getmapping_getaccess() throws IOException {

       when(controller.getAccessToken(Constants.accessToken)).thenReturn(Constants.accessToken);
        String output=interfaceGenerice.getAccessToken("getAccess_token");

assertEquals(controller.getAccessToken("fdsfg"),output);
    }
    @Test
    public void testPostCall() throws IOException {
        when(interfaceGenerice.getAccessToken("")).thenReturn(Constants.accessToken);
        System.out.println("calling -------------->");
        interfaceGenerice.getAccessToken("");
       assertEquals(112,controller.getAccessToken("getAccess_token").length());
    }
    @Test
    public void testGetLogFile() throws IOException {
      when(interfaceGenerice.getEventLogFile()).thenReturn(logResponse);

      String output=controller.getEventLogFile();

      assertEquals(logResponse,output);
      verify(interfaceGenerice,times(1)).getEventLogFile();
    }
}
