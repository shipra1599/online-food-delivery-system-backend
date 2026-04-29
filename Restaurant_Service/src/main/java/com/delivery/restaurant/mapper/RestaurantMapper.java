package com.delivery.restaurant.mapper;

import org.mapstruct.Mapper;

import com.delivery.restaurant.dto.RestaurantDTO;
import com.delivery.restaurant.entity.Restaurant;
import com.delivery.restaurant.vo.RestaurantVO;

@Mapper(componentModel = "spring")
public class RestaurantMapper {

	public static Restaurant toEntity(RestaurantVO vo) {
		Restaurant entity = new Restaurant();
		entity.setName(vo.getName());
		entity.setLocation(vo.getLocation());
		entity.setRating(vo.getRating());
		entity.setStatus(vo.getStatus());
		return entity;
	}

	public static RestaurantDTO toDTO(Restaurant entity) {
		RestaurantDTO dto = new RestaurantDTO();
		dto.setRestaurantId(entity.getRestaurantId());
		dto.setName(entity.getName());
		dto.setLocation(entity.getLocation());
		dto.setRating(entity.getRating());
		dto.setStatus(entity.getStatus());
		return dto;
	}

}
