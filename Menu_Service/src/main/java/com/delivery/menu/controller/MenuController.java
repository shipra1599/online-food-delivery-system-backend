package com.delivery.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.menu.dto.MenuDTO;
import com.delivery.menu.service.MenuService;
import com.delivery.menu.vo.MenuVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @PostMapping("/add")
    public String addMenu(@Valid @RequestBody MenuVO vo) {
        MenuDTO dto = service.addMenu(vo);
        return "Menu item " + dto.getItemName() + " added successfully!";
    }
    
    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuDTO> getMenusByRestaurant(@PathVariable ("restaurantId") Long restaurantId) {
        return service.getMenusByRestaurantId(restaurantId);
    }


}