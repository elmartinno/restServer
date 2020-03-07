package com.example.demo.Services;

import com.example.demo.model.Account;
import com.example.demo.Logs;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private Logs l;

    /*public String getTestName(String name) {
        Account t = testRepository.findByName(name);
        return t.getIban();
    }*/

    public List<Account> getTests() {
        l.startLog();

        List<Account> all = accountRepository.findAll();

        l.createLog("accounts","all");
        return all;
    }

    public Account findByIban(String iban) {
        l.startLog();

        Account byIban = accountRepository.findByIban(iban);

        l.createLog("findAccountByIban", iban);
        return  byIban;
    }

    public void addAccount(Account account){
        l.startLog();

        if(accountRepository.findByIban(account.getIban()) ==null)
            accountRepository.insert(account);
        else
            System.out.println("takyto iban uz existuje");

        l.createLog("addAccount", account.getIban());
    }

    public void updateAccount(Account account){
        l.startLog();

        if(accountRepository.findByIban(account.getIban()) !=null) {
            removeAccount(account.getIban());
            accountRepository.save(account);
        }
        else
            System.out.println("nemas co updatnut");

        l.createLog("updateAccount", account.getIban());
    }

    public void removeAccount(String iban) {
        l.startLog();

        if(accountRepository.findByIban(iban) !=null)
            accountRepository.delete(accountRepository.findByIban(iban));//.delete(account);
        else
            System.out.println("toto uz nejestvuje");

        l.createLog("removeAccount", iban);
    }

}
