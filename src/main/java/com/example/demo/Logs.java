package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Service
public class Logs {
    Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;
    Long start;

    public Logs(){

        try {

            fh = new FileHandler("/tmp/RestServer.txt",
                    true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            //logger.info("My first log");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startLog(){
        this.start=System.currentTimeMillis();
    }
    public void createLog(String method, String iban){
        logger.info(method+" "+iban+ " "+(System.currentTimeMillis()-start));
    }
}
