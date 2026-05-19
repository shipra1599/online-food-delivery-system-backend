package com.delivery.menu.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.delivery.menu.dto.RestaurantDTO;

@FeignClient(name = "restaurant-service",url = "http://localhost:8081/restaurants"
)
public interface RestaurantClient {

    @GetMapping("/id/{id}")
    RestaurantDTO getRestaurantById(@PathVariable("id") Long id);
}
