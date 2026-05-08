package com.delivery.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/{id}")
    public MenuDTO getMenuById(@PathVariable("id") Long id) {
        return service.getMenuById(id);
    }
    
    @GetMapping("/showAll")
    public List<MenuDTO> getAllMenus() {
        return service.getAllMenus();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMenu(@PathVariable("id") Long id,@RequestBody MenuVO vo) {
        MenuDTO updated = service.updateMenu(id, vo);
        return ResponseEntity.ok("Item '" + updated.getItemName() + "' updated successfully !!");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") Long id) {
        service.deleteMenu(id);
        return ResponseEntity.ok("Item with id " + id + " deleted successfully !!");
    }

}