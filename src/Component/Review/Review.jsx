import React, { useState, useEffect } from 'react';
import ReviewService from './ReviewService';
import GuestService from '../Guest/GuestService';  
import './Review.css';

const Review = () => {
  const [reviews, setReviews] = useState([]);
  const [guests, setGuests] = useState([]);
  const [reviewId, setReviewId] = useState('');
  const [guestId, setGuestId] = useState('');
  const [reviewRemark, setReviewRemark] = useState('');
  const [error, setError] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    fetchReviews();
    fetchGuests();
  }, []);

  const fetchReviews = async () => {
    try {
      const data = await ReviewService.getAllReviews();
      setReviews(data);
    } catch (err) {
      setError('Failed to fetch reviews');
    }
  };

  const fetchGuests = async () => {
    try {
      const data = await GuestService.getAllGuests();
      setGuests(data);
    } catch (err) {
      setError('Failed to fetch guests');
    }
  };

  const handleAddReview = async () => {
    const reviewData = { reviewId, reviewRemark, guest: { guestId } };
    try {
      if (!guestId || !reviewRemark) {
        setError('Guest ID and Review Remark are required');
        return;
      }

      if (isEditing) {
        await ReviewService.updateReview(reviewId, reviewData);
      } else {
        await ReviewService.createReview(reviewData);
      }

      fetchReviews();
      clearForm();
    } catch (err) {
      setError('Failed to create or update review');
    }
  };

  const handleEditReview = async (id) => {
    try {
      const review = await ReviewService.getReviewById(id);
      setReviewId(review.reviewId);
      setReviewRemark(review.reviewRemark);
      setGuestId(review.guest.guestId);
      setIsEditing(true);
    } catch (err) {
      setError('Failed to fetch review details');
    }
  };

  const handleDeleteReview = async (id) => {
    try {
      await ReviewService.deleteReview(id);
      fetchReviews();
    } catch (err) {
      setError('Failed to delete review');
    }
  };

  const clearForm = () => {
    setReviewId('');
    setReviewRemark('');
    setGuestId('');
    setIsEditing(false);
  };

  const getGuestNameById = (guestId) => {
    const guest = guests.find((g) => g.guestId === guestId);
    return guest ? guest.guestName : 'Unknown';
  };

  return (
    <div className="review-container">
      <h2>{isEditing ? 'Edit Review' : 'Add Review'}</h2>

      {error && <p className="error-message">{error}</p>}

      <div className="form-container">
        <input
          type="text"
          placeholder="Review ID"
          value={reviewId}
          onChange={(e) => setReviewId(e.target.value)}
          disabled={isEditing}
        />
        <select value={guestId} onChange={(e) => setGuestId(e.target.value)}>
          <option value="">Select Guest</option>
          {guests.map((guest) => (
            <option key={guest.guestId} value={guest.guestId}>
              {guest.guestName} (ID: {guest.guestId})
            </option>
          ))}
        </select>

        <input
          type="text"
          placeholder="Review Remark"
          value={reviewRemark}
          onChange={(e) => setReviewRemark(e.target.value)}
        />
        <button onClick={handleAddReview}>
          {isEditing ? 'Update Review' : 'Add Review'}
        </button>
      </div>

      <h3>All Reviews</h3>
      <div className="review-list">
        {reviews.map((review) => (
          <div key={review.reviewId} className="review-item">
            <h4>
              Review ID: {review.reviewId} <br />
              Review Remark: {review.reviewRemark} <br />
              Guest ID: {review.guest.guestId} <br />
              Guest Name: {getGuestNameById(review.guest.guestId)}
            </h4>
            <button onClick={() => handleEditReview(review.reviewId)}>Edit</button>
            <button onClick={() => handleDeleteReview(review.reviewId)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Review;
