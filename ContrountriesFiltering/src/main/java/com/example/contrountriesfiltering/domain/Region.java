package com.example.contrountriesfiltering.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Region {
    private String id;
    private String iso2code;
    private String value;

}
