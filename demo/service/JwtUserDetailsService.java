package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.PersonDTO;
import com.example.demo.model.Wallet;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private WalletRepository walletRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException("Username not found with username = " + username);
        }
        return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), new ArrayList<>());
    }

    public String save(PersonDTO user) {
        Person newPerson = new Person();
        Wallet newWallet = new Wallet();
        newPerson.setUsername(user.getUsername());
        newPerson.setPassword(bcryptEncoder.encode(user.getPassword()));
        newPerson.setEmail(user.getEmail());
        newPerson.setLastName(user.getLastname());
        newPerson.setFirstName(user.getFirstname());
        personRepository.save(newPerson);
        newWallet.setId(newPerson.getId());
        walletRepository.save(newWallet);
    return "saved";
    }

}