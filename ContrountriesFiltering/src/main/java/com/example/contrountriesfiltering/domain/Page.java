package com.example.contrountriesfiltering.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Page {
    private int page;
    private int pages;
    private String per_page;
    private int total;
}
