package com.delivery.restaurant.service;

import java.util.List;

import com.delivery.restaurant.dto.RestaurantDTO;
import com.delivery.restaurant.vo.RestaurantVO;

public interface RestaurantService {

	RestaurantDTO createRestaurant(RestaurantVO vo);
	List<RestaurantDTO> getAllRestaurants();
	RestaurantDTO getRestaurantByName(String name);

}
