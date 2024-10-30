import axios from 'axios';
import API_BASE_URL from '../Config';

const ReviewService = {
  getAllReviews: async () => {
    const response = await axios.get(`${API_BASE_URL}/reviews`);
    return response.data;
  },

  getReviewById: async (reviewId) => {
    const response = await axios.get(`${API_BASE_URL}/reviews/${reviewId}`);
    return response.data;
  },

  createReview: async (review) => {
    const response = await axios.post(`${API_BASE_URL}/reviews`, review, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  updateReview: async (reviewId, review) => {
    const response = await axios.put(`${API_BASE_URL}/reviews/${reviewId}`, review, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  deleteReview: async (reviewId) => {
    await axios.delete(`${API_BASE_URL}/reviews/${reviewId}`);
  },
};

export default ReviewService;
