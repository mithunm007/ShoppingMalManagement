package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Guest;
import com.example.demo.service.GuestService;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Guest guest = guestService.getGuestById(id);
        return ResponseEntity.ok(guest);
    }

    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest createdGuest = guestService.createGuest(guest);
        return ResponseEntity.ok(createdGuest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        Guest updatedGuest = guestService.updateGuest(id, guest);
        return ResponseEntity.ok(updatedGuest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
