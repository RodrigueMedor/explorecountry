package com.contries.Service;

import com.contries.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class CountriesServices {

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, List<Country>> getCountryByName(String name){
        String URL = "https://restcountries.eu/rest/v2/region/"+name;

        Country[] countries = restTemplate.getForObject(URL, Country[].class);

        return Arrays.asList(countries).stream().collect(groupingBy(Country::getRegion));

    }
}
