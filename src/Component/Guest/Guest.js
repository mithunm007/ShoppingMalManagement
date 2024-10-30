import React, { useState, useEffect } from 'react';
import GuestService from './GuestService';
import './Guest.css';

const Guest = () => {
  const [guests, setGuests] = useState([]);
  const [guestId, setGuestId] = useState('');
  const [guestName, setGuestName] = useState('');
  const [error, setError] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    fetchGuests();
  }, []);

  const fetchGuests = async () => {
    try {
      const data = await GuestService.getAllGuests();
      setGuests(data);
    } catch (err) {
      setError('Failed to fetch guests');
    }
  };

  const handleAddGuest = async () => {
    const guestData = { guestId, guestName };
    try {
      await GuestService.createGuest(guestData);
      fetchGuests();
      clearForm();
    } catch (err) {
      setError('Failed to create guest');
    }
  };

  const handleEditGuest = async (guestId) => {
    if (isEditing) {
      await GuestService.updateGuest(guestId, { guestName });
      fetchGuests();
      setIsEditing(false);
      clearForm();
    } else {
      const guest = await GuestService.getGuestById(guestId);
      setGuestId(guest.guestId);
      setGuestName(guest.guestName);
      setIsEditing(true);
    }
  };

  const handleDeleteGuest = async (guestId) => {
    try {
      await GuestService.deleteGuest(guestId);
      fetchGuests();
    } catch (err) {
      setError('Failed to delete guest');
    }
  };

  const clearForm = () => {
    setGuestId('');
    setGuestName('');
    setIsEditing(false);
  };

  return (
    <div className="guest-container">
      <h2>Manage Guests</h2>

      {error && <p className="error-message">{error}</p>}

      <div className="form-container">
        <input
          type="text"
          placeholder="Guest ID"
          value={guestId}
          onChange={(e) => setGuestId(e.target.value)}
        />
        <input
          type="text"
          placeholder="Guest Name"
          value={guestName}
          onChange={(e) => setGuestName(e.target.value)}
        />
        <button onClick={handleAddGuest}>
          {isEditing ? 'Update Guest' : 'Add Guest'}
        </button>
      </div>

      <h3>All Guests</h3>
      <div className="guest-list">
        {guests.map((guest) => (
          <div key={guest.guestId} className="guest-item">
            <h4>{guest.guestName}</h4>
            <h5>ID: {guest.guestId}</h5>

            <button onClick={() => handleEditGuest(guest.guestId)}>Edit</button>
            <button onClick={() => handleDeleteGuest(guest.guestId)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Guest;
