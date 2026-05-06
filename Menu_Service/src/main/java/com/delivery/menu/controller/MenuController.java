package com.delivery.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}