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

    /**
     * Injects the CartRepository bean for accessing cart-related data.
     */
    @Autowired
    private CartRepository cartRepository;

    /**
     * Injects the ProductRepository bean for accessing product-related data.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves a list of all carts from the database.
     *
     * @return A list of all Cart objects.
     */
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    /**
     * Retrieves a cart by its ID from the database.
     *
     * @param id The ID of the cart to retrieve.
     * @return The Cart object if found, or null if not found.
     */
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new cart and saves it to the database.
     *
     * @param cart The Cart object to create.
     * @return The created Cart object.
     */
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    /**
     * Updates an existing cart with the provided updated cart object.
     *
     * @param id The ID of the cart to update.
     * @param updatedCart The updated Cart object.
     * @return The updated Cart object if successful, or null if the original cart wasn't found.
     */
    public Cart updateCart(Long id, Cart updatedCart) {
        Optional<Cart> cartOptional = cartRepository.findById(id);

        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.setProducts(updatedCart.getProducts());
            return cartRepository.save(cart);
        }

        return null;
    }

    /**
     * Deletes a cart from the database by its ID.
     *
     * @param id The ID of the cart to delete.
     */
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    /**
     * Adds a product to a cart.
     *
     * @param cartId The ID of the cart.
     * @param productId The ID of the product.
     * @return The updated Cart object if successful, or null if the cart or product wasn't found.
     */
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

    /**
     * Retrieves the list of products associated with a cart.
     *
     * @param cartId The ID of the cart.
     * @return A list of Product objects if found, or null if the cart wasn't found.
     */
    public List<Product> getProductsInCart(Long cartId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);

        if (cartOptional.isPresent()) {
            return cartOptional.get().getProducts();
        }

        return null;
    }
}