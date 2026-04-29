package com.delivery.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.restaurant.dto.RestaurantDTO;
import com.delivery.restaurant.entity.Restaurant;
import com.delivery.restaurant.exception.RestaurantAlreadyExistsException;
import com.delivery.restaurant.mapper.RestaurantMapper;
import com.delivery.restaurant.repository.RestaurantRepository;
import com.delivery.restaurant.vo.RestaurantVO;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository repository;

	@Override
	public RestaurantDTO createRestaurant(RestaurantVO vo) {
		if (repository.existsByName(vo.getName())) {
			throw new RestaurantAlreadyExistsException("Restaurant already exists");
		}
		Restaurant entity = RestaurantMapper.toEntity(vo);
		Restaurant saved = repository.save(entity);
		return RestaurantMapper.toDTO(saved);
	}
}
