package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Guest;
import com.example.demo.repository.GuestRepository;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest updateGuest(Long id, Guest updatedGuest) {
        Guest guest = guestRepository.findById(id).orElse(null);
        if (guest != null) {
            guest.setGuestName(updatedGuest.getGuestName());
            return guestRepository.save(guest);
        }
        return null;
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
