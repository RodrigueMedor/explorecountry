package com.example.demofeigntest;

import com.example.demofeigntest.domain.Country;
import com.example.demofeigntest.services.APIServices;
import com.example.demofeigntest.services.APIServicesProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@EnableFeignClients(basePackageClasses = APIServicesProxy.class)
public class APIControllers implements APIServices {

//    @Autowired
    private APIServicesProxy proxy;

    public APIControllers(APIServicesProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    @GetMapping("/rest/v2/all")
    public List<Country> getCountries() {
        return proxy.getCountries();
    }

    @Override
    public List<Country> getProducts() {
        return null;
    }
}
