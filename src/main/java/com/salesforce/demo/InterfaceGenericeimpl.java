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
public class InterfaceGenericeimpl implements InterfaceGenerice,Constants {

/*
* To fetch Access token from post API call
* else fetch full json response
* */
    @Override
    public String getAccessToken(String arg1) throws IOException {
        System.out.println("interfaceGenericimpl method getAccessToken executed");
        String argValue="getAccess_token";
        AuthResponseValue  outputInClassObject;
        String result = "";
        HttpPost post = new HttpPost(tokenURL);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(grantTypeName,grant_type));
        urlParameters.add(new BasicNameValuePair(clientId,client_id));
        urlParameters.add( new BasicNameValuePair(clientSecret,client_secret));
        urlParameters.add( new BasicNameValuePair(userName,username));
        urlParameters.add(new BasicNameValuePair(passWord,password));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }
        //To get only access token using Gson object
        if(arg1.equals(argValue)) {
            Gson g = new Gson();
            outputInClassObject = g.fromJson(result, AuthResponseValue.class);

            String output=outputInClassObject.getAccess_token();
            System.out.println(output);
            return outputInClassObject.getAccess_token();
        }
        return result;
    }
    /*
    * Event log file
    * get API call response
    * */
    @Override
    public String getEventLogFile() throws IOException {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
String result="";
        try {
            InterfaceGenerice interfaceGenerice=new InterfaceGenericeimpl();
            HttpGet request = new HttpGet(eventLogFileURL);
            request.addHeader("Authorization","Bearer " +interfaceGenerice.getAccessToken("getAccess_token"));
            response = httpClient.execute(request);
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
        finally {
            response.close();
        }
            return result;
        }
    }
