package com.example.contrountriesfiltering.Controller;

import com.example.contrountriesfiltering.domain.Country;
import com.example.contrountriesfiltering.service.CountriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 6000)
//@RequestMapping(value="/explorecountries/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryExploreServiceController {

    @Autowired
    private CountriesServices countriesServices;

    @GetMapping("/countries/api/{iso2Code}")
    public  List<Country> getSimilarCountries(@PathVariable String iso2Code,
                                              @RequestParam(value = "regionCheck", required = false) boolean region,
                                              @RequestParam(value = "incomeLevelCheck", required = false) boolean incomeLevel,
                                              @RequestParam(value = "lendingTypeCheck", required = false) boolean lendingType){
        return countriesServices.getCountries(iso2Code,region, incomeLevel, lendingType);
    }
}
