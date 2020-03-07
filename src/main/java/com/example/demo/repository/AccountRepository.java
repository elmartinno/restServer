package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.Turnover;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{
    public Account findByIban(String iban);
    public List<Account> findAllByIban(String iban);

}
