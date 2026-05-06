package com.delivery.menu.vo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MenuVO {
	
    @NotNull(message = "Restaurant ID is required")
    @Positive(message = "Restaurant ID must be positive")
    private Long restaurantId;

    @NotBlank(message = "Item name is required")
    private String itemName;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price cannot be negative")
    private Double price;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Availability status is required")
    private Boolean isAvailable;
    
	public MenuVO() {

	}

	public MenuVO(Long restaurantId, String itemName, Double price, String category, Boolean isAvailable) {
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.category = category;
		this.isAvailable = isAvailable;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
