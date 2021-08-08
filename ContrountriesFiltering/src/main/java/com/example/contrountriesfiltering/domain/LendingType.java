package com.example.contrountriesfiltering.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LendingType {
    private String id;
    private String iso2code;
    private String value;
}
