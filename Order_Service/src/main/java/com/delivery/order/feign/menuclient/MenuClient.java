package com.delivery.order.feign.menuclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.delivery.order.dto.MenuDTO;

@FeignClient(name = "menu-service", url = "${menu.service.url}/menu")
public interface MenuClient {

    @GetMapping("/id/{id}")
    MenuDTO getMenuById(@PathVariable("id") Long id);
}