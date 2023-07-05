package com.example.demo.service;

import com.example.demo.model.Transaction;
import com.example.demo.model.Wallet;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class TransactionService {
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    TransactionRepository transactionRepository;
    LocalTime localTime = LocalTime.now();
    public String addTransaction(int firstPersonId,int secondPersonId,String result,String type,double amount){
        Transaction t = new Transaction();
        t.setPerson1(personRepository.findById(firstPersonId));
        t.setPerson2(personRepository.findById(secondPersonId));
        t.setResult(result);
        t.setType(type);
        t.setAmount(amount);
        t.setDate(localTime);

        switch (type) {
            case "dollar": {
                Wallet f = walletRepository.findById(firstPersonId).get();
                f.setValueInDollar(f.getValueInDollar() - amount);
                walletRepository.save(f);

                Wallet s = walletRepository.findById(secondPersonId).get();
                s.setValueInDollar(s.getValueInDollar() + amount);
                walletRepository.save(s);
                transactionRepository.save(t);
                return "saved";
            }
            case "rial": {
                Wallet f = walletRepository.findById(firstPersonId).get();
                f.setRial(f.getRial() - amount);
                walletRepository.save(f);

                Wallet s = walletRepository.findById(secondPersonId).get();
                s.setRial(s.getRial() + amount);
                walletRepository.save(s);
                transactionRepository.save(t);
                return "saved";
            }
            case "btc": {
                Wallet f = walletRepository.findById(firstPersonId).get();
                f.setValueInBtc(f.getValueInBtc() - amount);
                walletRepository.save(f);

                Wallet s = walletRepository.findById(secondPersonId).get();
                s.setValueInBtc(s.getValueInBtc() + amount);
                walletRepository.save(s);
                transactionRepository.save(t);
                return "saved";
            }
            default:
                throw new NullPointerException("Wrong Type");
        }

    }
}
