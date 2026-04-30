package com.delivery.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.restaurant.dto.RestaurantDTO;
import com.delivery.restaurant.entity.Restaurant;
import com.delivery.restaurant.exception.RestaurantAlreadyExistsException;
import com.delivery.restaurant.exception.RestaurantNotFoundException;
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
	
	@Override
	public List<RestaurantDTO> getAllRestaurants() {
		return repository.findAll()
		        .stream()
		        .map(entity -> RestaurantMapper.toDTO(entity))
		        .toList();
	}
	
	@Override
	public RestaurantDTO getRestaurantByName(String name) {
	    Restaurant entity = repository.findByName(name)
	            .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with name: " + name));

	    return RestaurantMapper.toDTO(entity);
	}

	@Override
	public RestaurantDTO updateRestaurantByName(String name, RestaurantVO vo) {
	    Restaurant entity = repository.findByName(name)
	            .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with name: " + name));
	    entity.setName(vo.getName());
	    entity.setLocation(vo.getLocation());
	    entity.setRating(vo.getRating());
	    entity.setStatus(vo.getStatus());
	    Restaurant updated = repository.save(entity);
	    return RestaurantMapper.toDTO(updated);
	}
	
	@Override
	public String deleteRestaurantByName(String name) {
	    Restaurant entity = repository.findByName(name)
	            .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with name: " + name));
	    repository.delete(entity);
	    return "Restaurant " + name + " deleted successfully!";
	}

}
