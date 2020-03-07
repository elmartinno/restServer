package com.example.demo.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private ObjectId _id;
    private String created;
    private String update;
    private String iban;
    private Balance balance;
    private String published;
    private String hidden;

    public void setIban(String iban){
        this.iban=iban;
    }

    public String getIban(){
        return this.iban;
    }
}
