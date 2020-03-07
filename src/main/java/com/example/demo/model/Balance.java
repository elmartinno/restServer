package com.example.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balance {
    private String value;
    private String precision;
    private String currency;
}
