package com.delivery.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.restaurant.dto.RestaurantDTO;
import com.delivery.restaurant.service.RestaurantService;
import com.delivery.restaurant.vo.RestaurantVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public String create(@Valid @RequestBody RestaurantVO vo) {
        RestaurantDTO dto = service.createRestaurant(vo);
        return "Restaurant " + dto.getName() + " added successfully";
    }

}
