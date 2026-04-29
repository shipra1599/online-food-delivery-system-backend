package com.delivery.restaurant.service;

import com.delivery.restaurant.dto.RestaurantDTO;
import com.delivery.restaurant.vo.RestaurantVO;

public interface RestaurantService {

	RestaurantDTO createRestaurant(RestaurantVO vo);

}
