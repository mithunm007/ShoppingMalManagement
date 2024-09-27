package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart updatedCart) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null) {
        // Updated to use User object
            cart.setProducts(updatedCart.getProducts()); // Updated to use Product object
            return cartRepository.save(cart);
        }
        return null;
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
    public Cart addProductToCart(Long cartId, Long productId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<Product> productOptional = productRepository.findById(productId);

        if (cartOptional.isPresent() && productOptional.isPresent()) {
            Cart cart = cartOptional.get();
            Product product = productOptional.get();

            List<Product> products = cart.getProducts();
            products.add(product);
            cart.setProducts(products);

            return cartRepository.save(cart);
        }

        return null;
    }
    
    public List<Product> getProductsInCart(Long cartId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);

        if (cartOptional.isPresent()) {
            return cartOptional.get().getProducts();
        }
        
        return null;
    }
}
