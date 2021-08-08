package com.example.contrountriesfiltering.service;

import com.example.contrountriesfiltering.domain.AdminRegion;
import com.example.contrountriesfiltering.domain.Country;
import com.example.contrountriesfiltering.domain.IncomeLevel;
import com.example.contrountriesfiltering.domain.LendingType;
import com.example.contrountriesfiltering.domain.Region;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class CountriesServices {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;

    public static String URL = "http://api.worldbank.org/v2/country?format=json";

    public List<Country> getCountries(String iso2Code, boolean regionCheck, boolean incomeLevelCheck, boolean lendingTypeCheck) {
        //  Object[] countries = restTemplate.getForObject(URL,Object[].class);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<Object>> listResponseEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Object>>() {
        });


        List<Country> list = (List<Country>) listResponseEntity.getBody().get(1);

        List<Country> countries = mapper.convertValue(list, new TypeReference<List<Country>>() {
        });

        Optional<Country> optionalCountry = countries.stream().filter(country -> country.getIso2Code().equals(iso2Code)).findFirst();

        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            Region region = country.getRegion();
            AdminRegion adminRegion = country.getAdminRegion();
            IncomeLevel incomeLevel = country.getIncomeLevel();
            LendingType lendingType = country.getLendingType();
            System.out.println(adminRegion);

            if (!regionCheck && !incomeLevelCheck & !lendingTypeCheck) {
                return Arrays.asList(country).stream().collect(Collectors.toList());
            } else if (regionCheck && !incomeLevelCheck & !lendingTypeCheck) {
                return countries.stream().filter(country1 -> country1.getRegion().getIso2code().equals(region.getIso2code())).collect(Collectors.toList());
            } else if (regionCheck && incomeLevelCheck & !lendingTypeCheck) {
                return countries.stream().filter(country1 -> country1.getRegion().getIso2code().equals(region.getIso2code()))
                        .filter(country1 -> country1.getIncomeLevel().getIso2code().equals(incomeLevel.getIso2code())).collect(Collectors.toList());
            } else if (regionCheck && !incomeLevelCheck & lendingTypeCheck) {
                return countries.stream().filter(country1 -> country1.getRegion().getIso2code().equals(region.getIso2code()))
                        .filter(country1 -> country1.getLendingType().getIso2code().equals(lendingType.getIso2code())).collect(Collectors.toList());
            } else if (!regionCheck && incomeLevelCheck & !lendingTypeCheck) {
                return countries.stream().filter(country1 -> country1.getIncomeLevel().getIso2code().equals(incomeLevel.getIso2code())).collect(Collectors.toList());
            } else if (!regionCheck && incomeLevelCheck & lendingTypeCheck) {
                return countries.stream().filter(country1 -> country1.getIncomeLevel().getIso2code().equals(incomeLevel.getIso2code()))
                        .filter(country1 -> country1.getLendingType().getIso2code().equals(lendingType.getIso2code())).collect(Collectors.toList());
            } else {
                return countries.stream().filter(country1 -> country1.getRegion().getIso2code().equals(region.getIso2code()))
                        .filter(country1 -> country1.getIncomeLevel().getIso2code().equals(incomeLevel.getIso2code()))
                        .filter(country1 -> country1.getLendingType().getIso2code().equals(lendingType.getIso2code())).collect(Collectors.toList());
            }
        }


        return null;
    }
}
