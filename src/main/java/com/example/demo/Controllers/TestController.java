package com.example.demo.Controllers;

import com.example.demo.Services.AccountService;
import com.example.demo.model.Account;
import com.example.demo.Services.TurnoverService;
import com.example.demo.model.Turnover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class TestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TurnoverService turnoverService;

    @GetMapping("/accounts")
    private List<Account> getAllAccounts() {
        return accountService.getTests();
    }

    //http://localhost:8080/api/findByIban/?iban=SK6009000000005133019509
    @GetMapping("/findAccountByIban")
    private Account getAccountById(String iban) {
        System.out.println(iban);
        return accountService.findByIban(iban);
    }

    @DeleteMapping("/removeAccount")
    private void removeAccount(String iban) {
        System.out.println(iban);
        accountService.removeAccount(iban);
    }

    @PutMapping("/updateAccount")
    private void updateAccount(@RequestBody Account account) {
        System.out.println(account.getIban());
        accountService.updateAccount(account);
    }

    //http://localhost:8080/api/addAccount
    @PostMapping(value = "/addAccount")//, consumes = "application/json", produces = "application/json")
    private boolean addAccount(@RequestBody Account account) {
        System.out.println(account);
        accountService.addAccount(account);
        return true;
    }

    @GetMapping("/version")
    //volanie: http://localhost:8080/api/version?id=value1
    public String version(String id) {
        System.out.println(id);
        return "v1";
    }

    /*
    @PostMapping("newTest")
    private void sendNewTest(@RequestBody Account account) {
        accountService.sendToDB(account);
    }*/


    @DeleteMapping("/removeTurnovers")
    private void removeTurnovers(String iban) {
        System.out.println(iban);
        turnoverService.removeTurnovers(iban);
    }

    @GetMapping("/turnovers")
    private List<Turnover> getAllTurnovers() {
        return turnoverService.getTests();
    }

    //http://localhost:8080/api/findTurnoversByIban/?iban=SK6009000000005133019509
    @GetMapping("/findTurnoversByIban")
    private List<Turnover> getTurnoversById(String iban) {
        System.out.println(iban);
        return turnoverService.findAllByAccountIban(iban);
    }
    //http://localhost:8080/api/addAccount
    @PostMapping(value = "/addTurnover")//, consumes = "application/json", produces = "application/json")
    private boolean addTurnover(@RequestBody Turnover turnover) {
        System.out.println(turnover);
        turnoverService.addTurnover(turnover);
        return true;
    }
    @PutMapping("/updateTurnovers")
    private void updateTurnovers(@RequestBody List<Turnover> turnovers) {
        //System.out.println(turnover.getIban());
        turnoverService.updateTurnovers(turnovers);
    }
}
