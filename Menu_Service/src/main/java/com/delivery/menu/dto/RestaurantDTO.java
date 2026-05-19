package com.delivery.menu.dto;

public class RestaurantDTO {

	private Long restaurantId;
	private String name;
	private String location;
	private Double rating;
	private String status;

	public RestaurantDTO() {

	}

	public RestaurantDTO(Long restaurantId, String name, String location, Double rating, String status) {
		this.restaurantId = restaurantId;
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.status = status;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
