package com.delivery.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	boolean existsByRestaurantIdAndItemName(Long restaurantId, String itemName);
}
