package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Guest;
import com.example.demo.service.GuestService;

import java.util.List;

@RestController // Indicates that this class is a RESTful controller that returns data as JSON or XML
@RequestMapping("/guests") // Base URL for all end points related to guests in this controller
public class GuestController {

    @Autowired // Injects the GuestService bean to handle business logic
    private GuestService guestService;

    /**
     * GET /guests
     * Retrieves a list of all guests.
     *
     * @return a list of all Guest entities.
     */
    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests(); // Calls the service to get all guests
    }

    /**
     * GET /guests/{id}
     * Retrieves a specific guest by their ID.
     *
     * @param id the ID of the guest to retrieve.
     * @return the Guest entity with the specified ID wrapped in a ResponseEntity.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Guest guest = guestService.getGuestById(id); // Calls the service to get a guest by ID
        return ResponseEntity.ok(guest); // Returns the guest in the response with a status code of 200 (OK)
    }

    /**
     * POST /guests
     * Creates a new guest.
     *
     * @param guest the Guest entity to be created.
     * @return the created Guest entity wrapped in a ResponseEntity.
     */
    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest createdGuest = guestService.createGuest(guest); // Calls the service to create a new guest
        return ResponseEntity.ok(createdGuest); // Returns the created guest with a status code of 200 (OK)
    }

    /**
     * PUT /guests/{id}
     * Updates an existing guest.
     *
     * @param id the ID of the guest to update.
     * @param guest the Guest entity containing the updated information.
     * @return the updated Guest entity wrapped in a ResponseEntity.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        Guest updatedGuest = guestService.updateGuest(id, guest); // Calls the service to update an existing guest
        return ResponseEntity.ok(updatedGuest); // Returns the updated guest with a status code of 200 (OK)
    }

    /**
     * DELETE /guests/{id}
     * Deletes an existing guest.
     *
     * @param id the ID of the guest to delete.
     * @return a ResponseEntity with no content and a status code of 204 (No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id); // Calls the service to delete a guest by ID
        return ResponseEntity.noContent().build(); // Returns an empty response with a status code of 204 (No Content)
    }
}
