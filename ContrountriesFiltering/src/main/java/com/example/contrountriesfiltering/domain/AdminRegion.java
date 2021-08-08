package com.example.contrountriesfiltering.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class AdminRegion {
    private String id;
    private String iso2code;
    private String value;


}
