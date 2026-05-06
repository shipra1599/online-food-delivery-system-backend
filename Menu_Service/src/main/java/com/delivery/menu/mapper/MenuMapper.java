package com.delivery.menu.mapper;

import com.delivery.menu.dto.MenuDTO;
import com.delivery.menu.entity.Menu;
import com.delivery.menu.vo.MenuVO;

public class MenuMapper {

    public static Menu toEntity(MenuVO vo) {
        Menu entity = new Menu();
        entity.setRestaurantId(vo.getRestaurantId());
        entity.setItemName(vo.getItemName());
        entity.setPrice(vo.getPrice());
        entity.setCategory(vo.getCategory());
        entity.setIsAvailable(vo.getIsAvailable());
        return entity;
    }

    public static MenuDTO toDTO(Menu entity) {
        MenuDTO dto = new MenuDTO();
        dto.setItemId(entity.getItemId());
        dto.setRestaurantId(entity.getRestaurantId());
        dto.setItemName(entity.getItemName());
        dto.setPrice(entity.getPrice());
        dto.setCategory(entity.getCategory());
        dto.setIsAvailable(entity.getIsAvailable());
        return dto;
    }
}
