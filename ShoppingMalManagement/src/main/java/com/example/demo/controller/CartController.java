package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/carts") // Base URL for all end points in this controller
public class CartController {

    @Autowired // Automatically injects the CartService dependency
    private CartService cartService;

    /**
     * GET /carts
     * Retrieves a list of all carts.
     *
     * @return a list of all Cart entities.
     */
    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts(); // Calls the service to get all carts
    }

    /**
     * GET /carts/{id}
     * Retrieves a specific cart by its ID.
     *
     * @param id the ID of the cart to retrieve.
     * @return the Cart entity with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Cart cart = cartService.getCartById(id); // Calls the service to get a cart by ID
        return ResponseEntity.ok(cart); // Returns the cart in the response with a status code of 200 (OK)
    }

    /**
     * POST /carts
     * Creates a new cart.
     *
     * @param cart the Cart entity to be created.
     * @return the created Cart entity.
     */
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.createCart(cart); // Calls the service to create a new cart
        return ResponseEntity.ok(createdCart); // Returns the created cart with a status code of 200 (OK)
    }

    /**
     * PUT /carts/{id}
     * Updates an existing cart.
     *
     * @param id the ID of the cart to update.
     * @param cart the Cart entity containing the updated information.
     * @return the updated Cart entity.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        Cart updatedCart = cartService.updateCart(id, cart); // Calls the service to update an existing cart
        return ResponseEntity.ok(updatedCart); // Returns the updated cart with a status code of 200 (OK)
    }

    /**
     * DELETE /carts/{id}
     * Deletes an existing cart.
     *
     * @param id the ID of the cart to delete.
     * @return a ResponseEntity with no content and a status code of 204 (No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id); // Calls the service to delete a cart by ID
        return ResponseEntity.noContent().build(); // Returns an empty response with a status code of 204 (No Content)
    }
}

