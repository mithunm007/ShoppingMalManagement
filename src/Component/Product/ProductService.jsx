import axios from 'axios';
import API_BASE_URL from '../Config';

const ProductService = {
  getAllProducts: async () => {
    const response = await axios.get(`${API_BASE_URL}/products`);
    return response.data;
  },

  getProductById: async (productId) => {
    const response = await axios.get(`${API_BASE_URL}/products/${productId}`);
    return response.data;
  },

  createProduct: async (product) => {
    const response = await axios.post(`${API_BASE_URL}/products`, product, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  updateProduct: async (productId, product) => {
    const response = await axios.put(`${API_BASE_URL}/products/${productId}`, product, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  deleteProduct: async (productId) => {
    await axios.delete(`${API_BASE_URL}/products/${productId}`);
  },
};

export default ProductService;
