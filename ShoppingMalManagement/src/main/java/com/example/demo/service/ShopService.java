package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shop;
import com.example.demo.repository.ShopRepository;


@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

     
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

     
    public Shop getShopById(Long shopId) {
        return shopRepository.findById(shopId).orElse(null);
    }

     
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

     
    public Shop updateShop(Long shopId, Shop shop) {
        Shop existingShop = shopRepository.findById(shopId).orElse(null);
        if (existingShop != null) {
            existingShop.setShopName(shop.getShopName());
            existingShop.setShopOwner(shop.getShopOwner());
            return shopRepository.save(existingShop);
        }
        return null;
    }

     
    public void deleteShop(Long shopId) {
        shopRepository.deleteById(shopId);
    }
}

