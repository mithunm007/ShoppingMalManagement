package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import java.util.List;

/**
 * This class serves as the RESTful API controller for managing product data.
 * It provides endpoints for retrieving, creating, updating, and deleting product information.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    /**
     * Injects the ProductService bean into the controller for accessing product-related services.
     */
    @Autowired
    private ProductService productService;

    /**
     * Handles GET requests to the root endpoint, returning a list of all products.
     *
     * @return A list of all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Handles GET requests to the endpoint with a specified ID, returning a single product.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the given ID, or a 404 Not Found response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * Handles POST requests to the root endpoint, creating a new product.
     *
     * @param product The product object to create.
     * @return The created product object.
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    /**
     * Handles PUT requests to the endpoint with a specified ID, updating an existing product.
     *
     * @param id The ID of the product to update.
     * @param product The updated product object.
     * @return The updated product object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Handles DELETE requests to the endpoint with a specified ID, deleting a product.
     *
     * @param id The ID of the product to delete.
     * @return A 204 No Content response indicating successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}