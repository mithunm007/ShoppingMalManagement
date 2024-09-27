package com.example.demo.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Login login;
  
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "cart_products", // Name of the join table
//        joinColumns = @JoinColumn(name = "cartId"), // Foreign key in join table referring to Cart entity
//        inverseJoinColumns = @JoinColumn(name = "pId") // Foreign key in join table referring to Product entity
//    )
//    private List<Product> products;
 
    
    @OneToMany(mappedBy = "carts") // 'products' references the Cart entity's property
    private List<Product> products;

    

    // Constructors, getters, and setters
    public Cart() {
    }

    public Cart(Long cartId, Login login, List<Product> products) {
        this.cartId = cartId;
        this.login = login;
        this.products = products;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", login=" + login + ", products=" + products + "]";
    }
}
