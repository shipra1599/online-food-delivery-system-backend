package com.delivery.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.menu.dto.MenuDTO;
import com.delivery.menu.entity.Menu;
import com.delivery.menu.exception.ItemNotFoundException;
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
    
    @Override
    public MenuDTO getMenuById(Long id) {

        Menu menu = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Menu item not found with id: " + id));

        return MenuMapper.toDTO(menu);
    }

    
    @Override
    public List<MenuDTO> getAllMenus() {
        return repository.findAll()
                .stream()
                .map(entity -> MenuMapper.toDTO(entity))
                .toList();
    }
    

    @Override
    public MenuDTO updateMenu(Long id, MenuVO vo) {

        Menu existing = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Menu item not found with id: " + id));
        if (vo.getItemName() != null) {
            existing.setItemName(vo.getItemName());
        }
        if (vo.getPrice() != null) {
            existing.setPrice(vo.getPrice());
        }
        if (vo.getCategory() != null) {
            existing.setCategory(vo.getCategory());
        }
        if (vo.getIsAvailable() != null) {
            existing.setIsAvailable(vo.getIsAvailable());
        }
        if (vo.getRestaurantId() != null) {
            existing.setRestaurantId(vo.getRestaurantId());
        }

        Menu updated = repository.save(existing);

        return MenuMapper.toDTO(updated);
    } 
    
    @Override
    public void deleteMenu(Long id) {

        Menu existing = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Menu item not found with id: " + id));
        repository.delete(existing);
    }

}
