package com.salesforce.demo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class TestApiResponse {

    @Mock
    InterfaceGenerice interfaceGenerice;
    @Rule
   public MockitoRule mockitoRule= MockitoJUnit.rule();
    @Test
    public void ControllerTtest_getmapping_getaccess() throws IOException {
       when(interfaceGenerice.getAccessToken("getAccess_token")).thenReturn("00D2w000003NJou!AQYAQBUNBRiBaNkOO0kcMZfc_3ZypAckLL4mjvbvAHqPPHhIGRiR9xzGJ6BilN5FXo.B5Zo5Iooe8EZE8jltRnY28PVGfBRO");

        assertEquals("00D2w000003NJou!AQYAQBUNBRiBaNkOO0kcMZfc_3ZypAckLL4mjvbvAHqPPHhIGRiR9xzGJ6BilN5FXo.B5Zo5Iooe8EZE8jltRnY28PVGfBRO",interfaceGenerice.getAccessToken("getAccess_token"));
    }
    @Test
    public void testPostCall() throws IOException {
        when(interfaceGenerice.getAccessToken("getAccess_token")).thenReturn("00D2w000003NJou!AQYAQMinCel7a_tOqKiuYh3bZCjrUqygwjd7KDp0HP6Vxy0QrEH9Zh1_eQgaQlbUpzo80EbvOHmGken8noTC_Yu.TYVqFuNP");
        System.out.println("calling -------------->");
        interfaceGenerice.getAccessToken("");
       assertEquals(112,interfaceGenerice.getAccessToken("getAccess_token").length());
    }
    @Test
    public void testGetLogFile() throws IOException {
      when(interfaceGenerice.getEventLogFile()).thenReturn("{\n" +
              "    \"objectDescribe\": {\n" +
              "        \"activateable\": false,\n" +
              "        \"createable\": false,\n" +
              "        \"custom\": false,\n" +
              "        \"customSetting\": false,\n" +
              "        \"deletable\": false,\n" +
              "        \"deprecatedAndHidden\": false,\n" +
              "        \"feedEnabled\": false,\n" +
              "        \"keyPrefix\": \"0AT\",\n" +
              "        \"label\": \"Event Log File\",\n" +
              "        \"labelPlural\": \"Event Log Files\",\n" +
              "        \"layoutable\": false,\n" +
              "        \"mergeable\": false,\n" +
              "        \"name\": \"EventLogFile\",\n" +
              "        \"queryable\": true,\n" +
              "        \"replicateable\": false,\n" +
              "        \"retrieveable\": true,\n" +
              "        \"searchable\": false,\n" +
              "        \"triggerable\": false,\n" +
              "        \"undeletable\": false,\n" +
              "        \"updateable\": false,\n" +
              "        \"urls\": {\n" +
              "            \"rowTemplate\": \"/services/data/v32.0/sobjects/EventLogFile/{ID}\",\n" +
              "            \"describe\": \"/services/data/v32.0/sobjects/EventLogFile/describe\",\n" +
              "            \"sobject\": \"/services/data/v32.0/sobjects/EventLogFile\"\n" +
              "        }\n" +
              "    },\n" +
              "    \"recentItems\": []\n" +
              "}");
      assertEquals("{\n" +
              "    \"objectDescribe\": {\n" +
              "        \"activateable\": false,\n" +
              "        \"createable\": false,\n" +
              "        \"custom\": false,\n" +
              "        \"customSetting\": false,\n" +
              "        \"deletable\": false,\n" +
              "        \"deprecatedAndHidden\": false,\n" +
              "        \"feedEnabled\": false,\n" +
              "        \"keyPrefix\": \"0AT\",\n" +
              "        \"label\": \"Event Log File\",\n" +
              "        \"labelPlural\": \"Event Log Files\",\n" +
              "        \"layoutable\": false,\n" +
              "        \"mergeable\": false,\n" +
              "        \"name\": \"EventLogFile\",\n" +
              "        \"queryable\": true,\n" +
              "        \"replicateable\": false,\n" +
              "        \"retrieveable\": true,\n" +
              "        \"searchable\": false,\n" +
              "        \"triggerable\": false,\n" +
              "        \"undeletable\": false,\n" +
              "        \"updateable\": false,\n" +
              "        \"urls\": {\n" +
              "            \"rowTemplate\": \"/services/data/v32.0/sobjects/EventLogFile/{ID}\",\n" +
              "            \"describe\": \"/services/data/v32.0/sobjects/EventLogFile/describe\",\n" +
              "            \"sobject\": \"/services/data/v32.0/sobjects/EventLogFile\"\n" +
              "        }\n" +
              "    },\n" +
              "    \"recentItems\": []\n" +
              "}",interfaceGenerice.getEventLogFile());
    }
}
