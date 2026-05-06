package com.delivery.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.menu.dto.MenuDTO;
import com.delivery.menu.entity.Menu;
import com.delivery.menu.exception.MenuAlreadyExistsException;
import com.delivery.menu.mapper.MenuMapper;
import com.delivery.menu.repository.MenuRepository;
import com.delivery.menu.vo.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public MenuDTO addMenu(MenuVO vo) {
    	if (repository.existsByRestaurantIdAndItemName(vo.getRestaurantId(), vo.getItemName())) {
    	    throw new MenuAlreadyExistsException("Menu item already exists for this restaurant");
    	}
        Menu entity = MenuMapper.toEntity(vo);
        Menu saved = repository.save(entity);
        return MenuMapper.toDTO(saved);
    }
    
    @Override
    public List<MenuDTO> getMenusByRestaurantId(Long restaurantId) {
        return repository.findByRestaurantId(restaurantId)
                .stream()
                .map(entity -> MenuMapper.toDTO(entity))
                .toList();
    }


}
