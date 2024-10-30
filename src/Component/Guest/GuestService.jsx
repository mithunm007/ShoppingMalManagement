import axios from 'axios';
import API_BASE_URL from '../Config';

const GuestService = {
  getAllGuests: async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}/guests`);
      return response.data;
    } catch (error) {
      console.error("Error fetching guests:", error);
      throw error;
    }
  },

  getGuestById: async (guestId) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/guests/${guestId}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching guest with ID ${guestId}:`, error);
      throw error;
    }
  },

  createGuest: async (guest) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/guests`, guest, {
        headers: { 'Content-Type': 'application/json' }
      });
      return response.data;
    } catch (error) {
      console.error("Error creating guest:", error);
      throw error;
    }
  },

  updateGuest: async (guestId, guest) => {
    try {
      const response = await axios.put(`${API_BASE_URL}/guests/${guestId}`, guest, {
        headers: { 'Content-Type': 'application/json' }
      });
      return response.data;
    } catch (error) {
      console.error(`Error updating guest with ID ${guestId}:`, error);
      throw error;
    }
  },

  deleteGuest: async (guestId) => {
    try {
      await axios.delete(`${API_BASE_URL}/guests/${guestId}`);
    } catch (error) {
      console.error(`Error deleting guest with ID ${guestId}:`, error);
      throw error;
    }
  },
};

export default GuestService;
