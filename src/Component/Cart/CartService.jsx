import axios from 'axios';
import API_BASE_URL from '../Config';

const CartService = {
  getAllCarts: async () => {
    const response = await axios.get(`${API_BASE_URL}/carts`);
    return response.data;
  },

  getCartById: async (cartId) => {
    const response = await axios.get(`${API_BASE_URL}/carts/${cartId}`);
    return response.data;
  },

  createCart: async (cart) => {
    const response = await axios.post(`${API_BASE_URL}/carts`, cart, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  deleteCart: async (cartId) => {
    await axios.delete(`${API_BASE_URL}/carts/${cartId}`);
  },
};

export default CartService;
