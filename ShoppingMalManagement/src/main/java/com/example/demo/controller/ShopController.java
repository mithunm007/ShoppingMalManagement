package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id) {
        Shop shop = shopService.getShopById(id);
        return ResponseEntity.ok(shop);
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop createdShop = shopService.createShop(shop);
        return ResponseEntity.ok(createdShop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        Shop updatedShop = shopService.updateShop(id, shop);
        return ResponseEntity.ok(updatedShop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}
