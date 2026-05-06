package com.delivery.menu.service;

import java.util.List;

import com.delivery.menu.dto.MenuDTO;
import com.delivery.menu.entity.Menu;
import com.delivery.menu.vo.MenuVO;

public interface MenuService {
	
	MenuDTO addMenu(MenuVO vo);
	List<MenuDTO> getMenusByRestaurantId(Long restaurantId);
	List<MenuDTO> getAllMenus();




}
