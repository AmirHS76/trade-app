package com.example.demo.repository;

import com.example.demo.model.Exchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

public interface ExchangeRepository extends CrudRepository<Exchange, Integer> {

}
