package com.example.demofeigntest.services;

//import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "api-service")
public interface APIServicesProxy extends APIServices{
}
