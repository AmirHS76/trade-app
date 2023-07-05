package com.example.demo.api;

import com.example.demo.dto.ApiGetContent;
import com.example.demo.dto.ApiPostTokenBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class BtcApi {
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/token")
    public String getToken() throws UnirestException, IOException {
        HttpResponse<String> response = Unirest.post("https://bravenewcoin.p.rapidapi.com/oauth/token")
                .header("content-type", "application/json")
                .header("x-rapidapi-key", "a5c27dcd3amsh30502d066980ee5p1ed791jsn99d6b3f22849")
                .header("x-rapidapi-host", "bravenewcoin.p.rapidapi.com")
                .body("{\r\n    \"audience\": \"https://api.bravenewcoin.com\",\r\n    \"client_id\": \"oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY\",\r\n    \"grant_type\": \"client_credentials\"\r\n}")
                .asString();
        String str = response.getBody();
        ApiPostTokenBody apiPostTokenBody = objectMapper.readValue(str, ApiPostTokenBody.class);
        String ss = apiPostTokenBody.getAccess_token();
        return ss;
    }

    @GetMapping("/get")
    public double getApi() throws IOException, UnirestException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://bravenewcoin.p.rapidapi.com/market-cap?assetId=f1ff77b6-3ab4-4719-9ded-2fc7e71cff1f")
                .get()
                .addHeader("authorization", "Bearer " + getToken())
                .addHeader("x-rapidapi-key", "a5c27dcd3amsh30502d066980ee5p1ed791jsn99d6b3f22849")
                .addHeader("x-rapidapi-host", "bravenewcoin.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        String s = response.body().string();
        ApiGetContent apiGetContent = objectMapper.readValue(s, ApiGetContent.class);
        return apiGetContent.getContent().get(0).getPrice();

    }
}