package com.delivery.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.restaurant.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	boolean existsByName(String name);
	Optional<Restaurant> findByName(String name);
}
