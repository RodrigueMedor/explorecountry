package com.example.demofeigntest.services;

import com.example.demofeigntest.domain.Country;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface APIServices {

    @GetMapping("/rest/v2/all")
    public List<Country> getCountries();



    @GetMapping("/countries")
    public List<Country> getProducts();
}
