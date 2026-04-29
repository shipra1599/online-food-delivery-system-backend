package com.delivery.restaurant.vo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestaurantVO {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Location is required")
	private String location;

	@DecimalMin(value = "0.0", message = "Rating cannot be negative")
	@DecimalMax(value = "5.0", message = "Rating cannot exceed 5.0")
	private Double rating;

	@NotBlank(message = "Status is required")
	private String status;

	public RestaurantVO() {
		super();
	}

	public RestaurantVO(String name, String location, Double rating, String status) {
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.status = status;
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
