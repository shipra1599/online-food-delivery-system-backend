package com.delivery.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Menu API",description = "Endpoints for managing menu items")
public class MenuController {

    @Autowired
    private MenuService service;

    @Operation(
        summary = "Add a new menu item",description = "Creates a new menu item for a restaurant."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Returns a message confirming the item was added"),
        @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping("/add")
    public String addMenu(@Valid @RequestBody MenuVO vo) {
        MenuDTO dto = service.addMenu(vo);
        return "Menu item " + dto.getItemName() + " added successfully!";
    }

    @Operation(
        summary = "Get menu items for a restaurant",description = "Fetches all menu items available for the given restaurant."
    )
    @ApiResponse(responseCode = "200", description = "Menu items retrieved successfully")
    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuDTO> getMenusByRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        return service.getMenusByRestaurantId(restaurantId);
    }

    @Operation(
        summary = "Get menu item by ID",description = "Returns the details of a menu item using its ID."
    )
    @ApiResponse(responseCode = "200", description = "Menu item retrieved successfully")
    @GetMapping("/id/{id}")
    public MenuDTO getMenuById(@PathVariable("id") Long id) {
        return service.getMenuById(id);
    }

    @Operation(
        summary = "Get all menu items",description = "Returns every menu item available across all restaurants."
    )
    @ApiResponse(responseCode = "200", description = "Menu items retrieved successfully")
    @GetMapping("/showAll")
    public List<MenuDTO> getAllMenus() {
        return service.getAllMenus();
    }

    @Operation(
        summary = "Update a menu item",description = "Updates a menu item using its ID and returns a confirmation message."
    )
    @ApiResponse(responseCode = "200", description = "Returns a message confirming the item was updated")
    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateMenu(@PathVariable("id") Long id, @RequestBody MenuVO vo) {
        MenuDTO updated = service.updateMenu(id, vo);
        return ResponseEntity.ok("Item '" + updated.getItemName() + "' updated successfully !!");
    }

    @Operation(
        summary = "Delete a menu item",description = "Deletes a menu item from the system using its ID."
    )
    @ApiResponse(responseCode = "200", description = "Returns a message confirming the item was deleted")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") Long id) {
        service.deleteMenu(id);
        return ResponseEntity.ok("Item with id " + id + " deleted successfully !!");
    }
}