import React, { useState, useEffect } from 'react';
import CartService from './CartService';
import './Cart.css';

const Cart = () => {
  const [carts, setCarts] = useState([]);
  const [cartId, setCartId] = useState('');
  const [products, setProducts] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchCarts();
  }, []);

  const fetchCarts = async () => {
    try {
      const data = await CartService.getAllCarts();
      setCarts(data);
    } catch (err) {
      setError('Failed to fetch carts');
    }
  };

  const handleAddCart = async () => {
    if (!cartId) {
      setError('Cart ID is required');
      return;
    }

    const cartData = { cartId };

    try {
      await CartService.createCart(cartData);
      fetchCarts();
      clearForm();
    } catch (err) {
      setError('Failed to create cart');
    }
  };

  const handleEditCart = async (id) => {
    try {
      const cart = await CartService.getCartById(id);
      setCartId(cart.cartId);
      setProducts(cart.products);
    } catch (err) {
      setError('Failed to fetch cart details');
    }
  };

  const handleDeleteCart = async (id) => {
    try {
      await CartService.deleteCart(id);
      fetchCarts();
    } catch (err) {
      setError('Failed to delete cart');
    }
  };

  const clearForm = () => {
    setCartId('');
    setProducts([]);
  };

  return (
    <div className="cart-container">
      <h2>Cart Management</h2>

      {error && <p className="error-message">{error}</p>}

      <div className="form-container">
        <input
          type="text"
          placeholder="Cart ID"
          value={cartId}
          onChange={(e) => setCartId(e.target.value)}
        />
        <button onClick={handleAddCart}>Add Cart</button>
      </div>

      <h3>All Carts</h3>
      <div className="cart-list">
        {carts.map((cart) => (
          <div key={cart.cartId} className="cart-item">
            <h4>Cart ID: {cart.cartId}</h4>

            <h5>Products:</h5>
            {cart.products && cart.products.length > 0 ? (
              <ul>
                {cart.products.map((product) => (
                  <li key={product.pid}>
                    <div>Product ID: {product.pid}</div>
                    <div>Name: {product.productName}</div>
                    <div>Category: {product.category}</div>
                    <div>Price: ${product.price}</div>
                  </li>
                ))}
              </ul>
            ) : (
              <p>No products in this cart</p>
            )}

            <button onClick={() => handleEditCart(cart.cartId)}>Edit</button>
            <button onClick={() => handleDeleteCart(cart.cartId)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Cart;
