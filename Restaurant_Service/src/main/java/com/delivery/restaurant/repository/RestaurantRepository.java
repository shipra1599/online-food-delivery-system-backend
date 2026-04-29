package com.delivery.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.restaurant.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	boolean existsByName(String name);


}
