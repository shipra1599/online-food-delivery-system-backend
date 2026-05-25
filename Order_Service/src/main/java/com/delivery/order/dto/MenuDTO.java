package com.delivery.order.dto;

public class MenuDTO {

	  private Long itemId;
	    private Long restaurantId;
	    private String itemName;
	    private Double price;
	    private String category;
	    private Boolean isAvailable;

	    public MenuDTO() {
	    }

	    public MenuDTO(Long itemId, Long restaurantId, String itemName, Double price, String category, Boolean isAvailable) {
	        this.itemId = itemId;
	        this.restaurantId = restaurantId;
	        this.itemName = itemName;
	        this.price = price;
	        this.category = category;
	        this.isAvailable = isAvailable;
	    }

	    public Long getItemId() {
	        return itemId;
	    }

	    public void setItemId(Long itemId) {
	        this.itemId = itemId;
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