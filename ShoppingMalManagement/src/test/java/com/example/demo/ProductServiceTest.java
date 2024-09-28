package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@SpringBootTest
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Initialize sample data
        product = new Product(1L, "Product 1", "Category", 100.0, null);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.save(product)).thenReturn(product);
        Product savedProduct = productService.createProduct(product);
        assertNotNull(savedProduct);
        assertEquals(product.getpId(), savedProduct.getpId());
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Product foundProduct = productService.getProductById(1L);
        assertNotNull(foundProduct);
        assertEquals(product.getpId(), foundProduct.getpId());
    }

    @Test
    void testUpdateProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        product.setPrice(150.0);
        when(productRepository.save(product)).thenReturn(product);
        Product updatedProduct = productService.updateProduct(1L, product);
        assertNotNull(updatedProduct);
        assertEquals(150.0, updatedProduct.getPrice());
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}
