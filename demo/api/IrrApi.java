package com.example.demo.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class IrrApi {

    @PostMapping("/rri")
    public double getPrice() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://parsijoo.ir/api?serviceType=price-API&query=Currency")
                .build();
        Response response = client.newCall(request).execute();
        String s = response.body().string();
        String[] st = s.split("CDATA");
        String str = st[3].replaceAll("[^۰-۹]+", "");
        String englishNum = new BigDecimal(str).toString();
        return Double.parseDouble(englishNum);
    }
}
