package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;

/**
 * This class serves as a service component for managing product data.
 * It provides methods for retrieving, creating, updating, and deleting product information.
 */
@Service
public class ProductService {

    /**
     * Injects the ProductRepository bean for interacting with the product data store (likely a database).
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves a list of all products from the repository.
     *
     * @return A list of all Product objects.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its ID from the repository.
     *
     * @param id The ID of the product to retrieve.
     * @return The Product object if found, or null if not found.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new product and saves it to the repository.
     *
     * @param product The Product object to create.
     * @return The created Product object.
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates an existing product with the provided details.
     *
     * @param id The ID of the product to update.
     * @param updatedProduct The updated Product object containing new details.
     * @return The updated Product object if successful, or null if the original product wasn't found.
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            // Update multiple fields (name, category, price) from the provided Product object
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setPrice(updatedProduct.getPrice());

            return productRepository.save(existingProduct);
        }
        return null;
    }

    /**
     * Deletes a product from the repository based on its ID.
     *
     * @param id The ID of the product to delete.
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}