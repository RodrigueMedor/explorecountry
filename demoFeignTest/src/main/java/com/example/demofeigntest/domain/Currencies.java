package com.example.demofeigntest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Currencies {

    private String code;
    private String name;
    private String symbol;
}
