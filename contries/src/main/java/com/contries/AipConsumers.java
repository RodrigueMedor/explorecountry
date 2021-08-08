package com.contries;

import com.contries.Service.CountriesServices;
import com.contries.domain.Country;
import com.contries.domain.Currencies;
import com.contries.domain.RegionalBlocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@RestController
public class AipConsumers {

    @Autowired
    RestTemplate restTemplate;
    private static String URL = "https://restcountries.eu/rest/v2/all";
    private static String URL_Country = "https://restcountries.eu/rest/v2/name";
    @Autowired
    private CountriesServices countriesServices;

    @GetMapping("/countries")
    public  Map<String, List<Country>>  getReadCountries(){
        Country[] objects =  restTemplate.getForObject(URL, Country[].class);

        Map<String, List<Country>> listMap = Arrays.asList(objects).stream().distinct().collect(groupingBy(Country::getRegion));

        return listMap;

     //   return Arrays.asList(objects).stream().filter(x ->x.getName().equals("Afghanistan")).collect(Collectors.toList());
    }

    @GetMapping("/search/{countryName}")
    public Map<String, List<Country>> getByCountryName(@PathVariable String countryName){
        return countriesServices.getCountryByName(countryName);
    }
}
