package com.example.contrountriesfiltering.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Country {
    private String id;
    private String iso2Code;
    private String name;
    private Region region;
    private AdminRegion adminRegion;
    private IncomeLevel incomeLevel;
    private LendingType lendingType;
    private String capitalCity;
    private String longitude;
    private String latitude;

}
