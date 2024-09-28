package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Guest;
import com.example.demo.repository.GuestRepository;

import java.util.List;

/**
 * This class serves as a service component for managing guest data.
 * It provides methods for retrieving, creating, updating, and deleting guest information.
 */
@Service
public class GuestService {

    /**
     * Injects the GuestRepository bean for interacting with the guest data store (likely a database).
     */
    @Autowired
    private GuestRepository guestRepository;

    /**
     * Retrieves a list of all guests from the repository.
     *
     * @return A list of all Guest objects.
     */
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    /**
     * Retrieves a guest by its ID from the repository.
     *
     * @param id The ID of the guest to retrieve.
     * @return The Guest object if found, or null if not found.
     */
    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new guest and saves it to the repository.
     *
     * @param guest The Guest object to create.
     * @return The created Guest object.
     */
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    /**
     * Updates an existing guest with the provided details.
     *
     * @param id The ID of the guest to update.
     * @param updatedGuest The updated Guest object containing new details.
     * @return The updated Guest object if successful, or null if the original guest wasn't found.
     */
    public Guest updateGuest(Long id, Guest updatedGuest) {
        Guest existingGuest = guestRepository.findById(id).orElse(null);
        if (existingGuest != null) {
            // Update only the guest name from the provided Guest object
            existingGuest.setGuestName(updatedGuest.getGuestName());

            return guestRepository.save(existingGuest);
        }
        return null;
    }

    /**
     * Deletes a guest from the repository based on their ID.
     *
     * @param id The ID of the guest to delete.
     */
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}