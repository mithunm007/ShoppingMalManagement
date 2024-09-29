package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;

@SpringBootTest
class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    private Cart cart;
    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Initialize sample data
        product = new Product(1L, "Product 1", "Category", 100.0);
        cart = new Cart(1L, null, null);
    }

    @Test
    void testAddCart() {
        when(cartRepository.save(cart)).thenReturn(cart);
        Cart savedCart = cartService.createCart(cart);
        assertNotNull(savedCart);
        assertEquals(cart.getCartId(), savedCart.getCartId());
    }

    @Test
    void testGetCartById() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        Cart foundCart = cartService.getCartById(1L);
        assertNotNull(foundCart);
        assertEquals(cart.getCartId(), foundCart.getCartId());
    }

    @Test
    void testUpdateCart() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        cart.setProducts(Arrays.asList(new Product(2L, "Product 2", "Category", 150.0)));
        when(cartRepository.save(cart)).thenReturn(cart);
        Cart updatedCart = cartService.updateCart(1L, cart);
        assertNotNull(updatedCart);
        assertEquals(1, updatedCart.getProducts().size());
    }

    @Test
    void testDeleteCart() {
        doNothing().when(cartRepository).deleteById(1L);
        cartService.deleteCart(1L);
        verify(cartRepository, times(1)).deleteById(1L);
    }
}
