package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shop;
import com.example.demo.repository.ShopRepository;

/**
 * This class serves as a service component for managing shop data.
 * It provides methods for retrieving, creating, updating, and deleting shop information.
 */
@Service
public class ShopService {

    /**
     * Injects the ShopRepository bean for interacting with the shop data store (likely a database).
     */
    @Autowired
    private ShopRepository shopRepository;

    /**
     * Retrieves a list of all shops from the repository.
     *
     * @return A list of all Shop objects.
     */
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    /**
     * Retrieves a shop by its ID from the repository.
     *
     * @param shopId The ID of the shop to retrieve.
     * @return The Shop object if found, or null if not found.
     */
    public Shop getShopById(Long shopId) {
        return shopRepository.findById(shopId).orElse(null);
    }

    /**
     * Creates a new shop and saves it to the repository.
     *
     * @param shop The Shop object to create.
     * @return The created Shop object.
     */
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    /**
     * Updates an existing shop with the provided details.
     *
     * @param shopId The ID of the shop to update.
     * @param shop The updated Shop object containing new details.
     * @return The updated Shop object if successful, or null if the original shop wasn't found.
     */
    public Shop updateShop(Long shopId, Shop shop) {
        Shop existingShop = shopRepository.findById(shopId).orElse(null);
        if (existingShop != null) {
            // Update both shop name and owner from the provided Shop object
            existingShop.setShopName(shop.getShopName());
            existingShop.setShopOwner(shop.getShopOwner());

            return shopRepository.save(existingShop);
        }
        return null;
    }

    /**
     * Deletes a shop from the repository based on its ID.
     *
     * @param shopId The ID of the shop to delete.
     */
    public void deleteShop(Long shopId) {
        shopRepository.deleteById(shopId);
    }
}