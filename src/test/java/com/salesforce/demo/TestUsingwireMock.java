package com.salesforce.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Result;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static sun.nio.cs.Surrogate.is;


public class TestUsingwireMock {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);


    @Test
    public void testWireMockApi() throws IOException {
        stubFor(get(urlEqualTo("/salesforce/hello"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("hello world")));

        String url = "http://localhost:8080/salesforce/hello";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Accept", "application/json");
        HttpResponse response = client.execute(request);

        verify(getRequestedFor(urlPathEqualTo("/salesforce/hello"))
                .withHeader("Content-Type", equalTo("application/json")));
      //  verify(postRequestedFor(urlEqualTo("/salesforce/hello"))
            //    .withHeader("Content-Type", equalTo("application/json")));//.withRequestBody(matching("hello world")));

       /* verify(postRequestedFor(urlMatching("/salesforce/hello"))
                .withRequestBody(matching("Hello world!"))
                .withHeader("Content-Type", notMatching("text/plain")));*/

    }
}
