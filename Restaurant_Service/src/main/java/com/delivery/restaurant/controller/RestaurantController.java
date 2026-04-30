package com.delivery.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/add")
    public String create(@Valid @RequestBody RestaurantVO vo) {
        RestaurantDTO dto = service.createRestaurant(vo);
        return "Restaurant " + dto.getName() + " added successfully";
    }
    
    @GetMapping("/showAll")
    public List<RestaurantDTO> getAll() {
        return service.getAllRestaurants();
    }
    
    @GetMapping("/{name}")
    public RestaurantDTO getByName(@PathVariable("name") String name) {
        return service.getRestaurantByName(name);
    }
    
    @PutMapping("/{name}")
    public String updateByName(@PathVariable("name") String name,@RequestBody RestaurantVO vo) {
        service.updateRestaurantByName(name, vo);
        return "Restaurant " + name + " updated successfully!";
    }


}
