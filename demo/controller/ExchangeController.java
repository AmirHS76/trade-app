package com.example.demo.controller;

import com.example.demo.exception.FailedException;
import com.example.demo.service.ExchangeService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("exchange")
public class ExchangeController {
    @Autowired
    ExchangeService exchangeService;

    @PostMapping("add")
    public String addnewExchange(@RequestParam String source, @RequestParam String destination,
                                 @NotNull @RequestParam String result, @RequestParam double amount,
                                 @RequestParam int personid) throws UnirestException, IOException, NullPointerException, IllegalArgumentException, FailedException {
        exchangeService.addNewExchange(source, destination, result, amount, personid);
        return "saved";
    }
}
