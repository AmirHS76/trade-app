package com.example.demo.service;

import com.example.demo.api.BtcApi;
import com.example.demo.api.IrrApi;
import com.example.demo.exception.FailedException;
import com.example.demo.model.Exchange;
import com.example.demo.model.Wallet;
import com.example.demo.repository.ExchangeRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.WalletRepository;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;

@Service
public class ExchangeService {
    @Autowired
    ExchangeRepository exchangeRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BtcApi btcApi;
    @Autowired
    IrrApi irrApi;
    LocalTime localTime = LocalTime.now();

    public void addNewExchange(@NotNull String source, String destination, @NotNull String result, double amount, int personid) throws UnirestException, IOException, FailedException {
        Exchange e = new Exchange();
        e.setSource(source);
        e.setDestination(destination);
        e.setResult(result);
        e.setAmount(amount);
        e.setPerson(personRepository.findById(personid));
        e.setTime(localTime);

        if (result.equals("success")) {
            Wallet w = walletRepository.findById(personid).get();
            if (source.equals("btc") && destination.equals("dollar")) {
                w.setValueInBtc(w.getValueInBtc() - amount);
                w.setValueInDollar(w.getValueInDollar() + (amount * btcApi.getApi()));
                walletRepository.save(w);
                exchangeRepository.save(e);
            } else if (source.equals("dollar") && destination.equals("btc")) {
                w.setValueInDollar(w.getValueInDollar() - amount);
                w.setValueInBtc(w.getValueInBtc() + (amount * (1 / btcApi.getApi())));
                walletRepository.save(w);
                exchangeRepository.save(e);
            } else if (source.equals("rial") && destination.equals("dollar")) {
                w.setRial(w.getRial() - amount);
                w.setValueInDollar(w.getValueInDollar() + (amount * (1 / irrApi.getPrice())));
                walletRepository.save(w);
                exchangeRepository.save(e);
            } else if (source.equals("rial") && destination.equals("btc")) {
                w.setRial(w.getRial() - amount);
                w.setValueInBtc(w.getValueInBtc() + (irrApi.getPrice() * btcApi.getApi() * amount));
                walletRepository.save(w);
                exchangeRepository.save(e);
            } else if (source.equals("btc") && destination.equals("rial")) {
                w.setValueInBtc(w.getValueInBtc() - amount);
                w.setRial(w.getRial() + (1 / irrApi.getPrice() * btcApi.getApi() * amount));
                walletRepository.save(w);
                exchangeRepository.save(e);
            } else {
                throw new IllegalArgumentException("wrong source");
            }
        } else {
            throw new FailedException("Something went wrong please try again");
        }
    }
}
