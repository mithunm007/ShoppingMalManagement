package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;

import java.util.List;

/**
 * This class serves as the RESTful API controller for managing shop data.
 * It provides endpoints for retrieving, creating, updating, and deleting shop information.
 */
@RestController
@RequestMapping("/shops")
public class ShopController {

    /**
     * Injects the ShopService bean into the controller for accessing shop-related services.
     */
    @Autowired
    private ShopService shopService;

    /**
     * Handles GET requests to the root endpoint, returning a list of all shops.
     *
     * @return A list of all shops.
     */
    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    /**
     * Handles GET requests to the endpoint with a specified ID, returning a single shop.
     *
     * @param id The ID of the shop to retrieve.
     * @return The shop with the given ID, or a 404 Not Found response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id) {
        Shop shop = shopService.getShopById(id);
        return ResponseEntity.ok(shop);
    }

    /**
     * Handles POST requests to the root endpoint, creating a new shop.
     *
     * @param shop The shop object to create.
     * @return The created shop object.
     */
    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop createdShop = shopService.createShop(shop);
        return ResponseEntity.ok(createdShop);
    }

    /**
     * Handles PUT requests to the endpoint with a specified ID, updating an existing shop.
     *
     * @param id The ID of the shop to update.
     * @param shop The updated shop object.
     * @return The updated shop object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        Shop updatedShop = shopService.updateShop(id, shop);
        return ResponseEntity.ok(updatedShop);
    }

    /**
     * Handles DELETE requests to the end point with a specified ID, deleting a shop.
     *
     * @param id The ID of the shop to delete.
     * @return A 204 No Content response indicating successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}