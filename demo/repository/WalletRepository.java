package com.example.demo.repository;

import com.example.demo.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {
}
