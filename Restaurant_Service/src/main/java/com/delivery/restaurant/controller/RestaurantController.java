package com.delivery.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(
    name = "Restaurant API",
    description = "Endpoints for managing restaurant information"
)
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @Operation(
        summary = "Add a new restaurant",
        description = "Creates a new restaurant with name, location, rating, and status."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Restaurant added successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping("/add")
    public String create(@Valid @RequestBody RestaurantVO vo) {
        RestaurantDTO dto = service.createRestaurant(vo);
        return "Restaurant " + dto.getName() + " added successfully";
    }

    @Operation(
        summary = "Get all restaurants",
        description = "Returns a list of all restaurants in the system."
    )
    @ApiResponse(responseCode = "200", description = "Restaurants retrieved successfully")
    @GetMapping("/showAll")
    public List<RestaurantDTO> getAll() {
        return service.getAllRestaurants();
    }

    @Operation(
        summary = "Get restaurant by name",
        description = "Fetches restaurant details using the restaurant name."
    )
    @ApiResponse(responseCode = "200", description = "Restaurant retrieved successfully")
    @GetMapping("/{name}")
    public RestaurantDTO getByName(@PathVariable("name") String name) {
        return service.getRestaurantByName(name);
    }

    @Operation(
        summary = "Update restaurant by name",
        description = "Updates restaurant details using the restaurant name."
    )
    @ApiResponse(responseCode = "200", description = "Restaurant updated successfully")
    @PutMapping("/{name}")
    public String updateByName(@PathVariable("name") String name, @RequestBody RestaurantVO vo) {
        service.updateRestaurantByName(name, vo);
        return "Restaurant " + name + " updated successfully!";
    }

    @Operation(
        summary = "Delete restaurant by name",
        description = "Deletes a restaurant using its name."
    )
    @ApiResponse(responseCode = "200", description = "Restaurant deleted successfully")
    @DeleteMapping("/{name}")
    public String deleteByName(@PathVariable("name") String name) {
        return service.deleteRestaurantByName(name);
    }

    @Operation(
        summary = "Get restaurant by ID",
        description = "Fetches restaurant details using the restaurant ID."
    )
    @ApiResponse(responseCode = "200", description = "Restaurant retrieved successfully")
    @GetMapping("/id/{id}")
    public RestaurantDTO getById(@PathVariable("id") Long id) {
        return service.getRestaurantById(id);
    }
}