package com.example.demo.Services;

import com.example.demo.Logs;
import com.example.demo.model.Account;
import com.example.demo.model.Turnover;
import com.example.demo.repository.TurnoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoverService {
    @Autowired
    private TurnoverRepository turnoverRepository;
    @Autowired
    private Logs l;

    public List<Turnover> getTests() {
        l.startLog();

        List<Turnover> all = turnoverRepository.findAll();

        l.createLog("turnovers","all");
        return all;
    }

    public List<Turnover> findAllByAccountIban(String iban){
        l.startLog();

        List<Turnover> allByAccountIban = turnoverRepository.findAllByAccountIban(iban);

        l.createLog("findTurnoversByIban",iban);
        return allByAccountIban;
    }

    public void addTurnover(Turnover turnover){
        l.startLog();

        turnoverRepository.insert(turnover);

        l.createLog("addTurnover",turnover.getIban());
    }

    public void removeTurnovers(String iban) {
        l.startLog();

        if(turnoverRepository.findAllByAccountIban(iban)!=null)
            turnoverRepository.deleteAll(turnoverRepository.findAllByAccountIban(iban));//.delete(account);
        else
            System.out.println("toto uz neexistuje");

        l.createLog("removeTurnovers",iban);
    }

//    public void removeTurnovers(String iban) {
//        l.startLog();
//
//        try {
//            turnoverRepository.deleteAll(turnoverRepository.findAllByAccountIban(iban));//.delete(account);
//        }catch (Exception e) {
//            System.out.println("toto uz neexistuje");
//        }
//
//        l.createLog("removeTurnovers",iban);
//    }

    public void updateTurnovers(List<Turnover> turnovers) {
        l.startLog();

        if(turnoverRepository.findAllByAccountIban(turnovers.get(0).getIban())!=null) {
            removeTurnovers(turnovers.get(0).getIban());
            turnoverRepository.saveAll(turnovers);
        }
        else
            System.out.println("toto uz neexistuje");

        l.createLog("updateTurnovers",turnovers.get(0).getIban());
    }
    /*public void sendToDB(Turnover turnover) {
        turnoverRepository.insert(turnover);
    }*/

    /*public String getTestName(String name) {
        Account t = testRepository.findByName(name);
        return t.getIban();
    }*/
}
