package com.salesforce.demo;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class InterfaceGenericeimpl implements InterfaceGenerice {

    @Override
    public String getAccessToken(String arg1) throws IOException {
        AuthResponseValue  outputInClassObject;
        String result = "";
        HttpPost post = new HttpPost("https://login.salesforce.com/services/oauth2/token");

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("grant_type","password"));
        urlParameters.add(new BasicNameValuePair("client_id","3MVG9n_HvETGhr3Du6ck5xE.hxjLFYw1B3dCCSJVDg0jkQa5e0siDfsRLWutJkmtdH2kZVQJR88TT4xuK5Ld_"));
        urlParameters.add( new BasicNameValuePair("client_secret","A602E313D5A28046A19A8211E46CDFD54F20CD9E8852A54C76E1AC1A81853331"));
        urlParameters.add( new BasicNameValuePair("username","arun.kumar@sacumen.com"));
        urlParameters.add(new BasicNameValuePair("password","Arun@1234"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){
            result = EntityUtils.toString(response.getEntity());
        }
        if(arg1.equals("getAccess_token")) {
            Gson g = new Gson();
            outputInClassObject = g.fromJson(result, AuthResponseValue.class);
            System.out.println("returned Access token");
            return outputInClassObject.getAccess_token();
        }
        System.out.println("not returnig Access token");
        return result;
    }

    @Override
    public String getEventLogFile() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
String result="";

        try {
            //SalesForcePostApi obj=new SalesForcePostApi();
            // AuthResponseValue resp= obj.sendPOST("https://login.salesforce.com/services/oauth2/token");
            HttpGet request = new HttpGet("https://ap16.salesforce.com/services/data/v32.0/sobjects/EventLogFile");
            request.addHeader("Authorization","Bearer " +"00D2w000003NJou!AQYAQJ8ghhR2oJgoO6a0ZSh3d1BQSpuObQwK7QdbLXtIWpYyeWcj1PKWtRrGlLrzAIi_jbyqreDbro6446qB4kYG65euQMdw");
            // obj.postCall();


            CloseableHttpResponse response = httpClient.execute(request);


            try {

                // Get HttpResponse Status
                System.out.println("getProtocolVersion " + response.getProtocolVersion());              // HTTP/1.1
                System.out.println("getStatusCode " + response.getStatusLine().getStatusCode());   // 200
                System.out.println("getReasonPhrase " + response.getStatusLine().getReasonPhrase()); // OK
                System.out.println("getStatusLine " + response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                     result = EntityUtils.toString(entity);
                    System.out.println("Result = " + result);
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();

            }
        }catch (Exception e) {
            e.printStackTrace();
            }
            return result;
        }
    }
