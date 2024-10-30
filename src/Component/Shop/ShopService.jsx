import axios from 'axios';
import API_BASE_URL from '../Config';

const ShopService = {
  getAllShops: async () => {
    const response = await axios.get(`${API_BASE_URL}/shops`);
    return response.data;
  },

  getShopById: async (shopId) => {
    const response = await axios.get(`${API_BASE_URL}/shops/${shopId}`);
    return response.data;
  },

  createShop: async (shop) => {
    const response = await axios.post(`${API_BASE_URL}/shops`, shop, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  updateShop: async (shopId, shop) => {
    const response = await axios.put(`${API_BASE_URL}/shops/${shopId}`, shop, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  deleteShop: async (shopId) => {
    await axios.delete(`${API_BASE_URL}/shops/${shopId}`);
  },
};

export default ShopService;
