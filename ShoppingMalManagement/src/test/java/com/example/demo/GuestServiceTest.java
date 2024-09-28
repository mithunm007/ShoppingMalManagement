package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Guest;
import com.example.demo.repository.GuestRepository;
import com.example.demo.service.GuestService;

@SpringBootTest
class GuestServiceTest {

    @Mock
    private GuestRepository guestRepository;

    @InjectMocks
    private GuestService guestService;

    private Guest guest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Initialize sample data
        guest = new Guest(1L, "Guest 1");
    }

    @Test
    void testGetGuestById() {
        when(guestRepository.findById(1L)).thenReturn(Optional.of(guest));
        Guest foundGuest = guestService.getGuestById(1L);
        assertNotNull(foundGuest);
        assertEquals(guest.getGuestId(), foundGuest.getGuestId());
    }

    @Test
    void testUpdateGuest() {
        when(guestRepository.findById(1L)).thenReturn(Optional.of(guest));
        guest.setGuestName("Updated Guest Name");
        when(guestRepository.save(guest)).thenReturn(guest);
        Guest updatedGuest = guestService.updateGuest(1L, guest);
        assertNotNull(updatedGuest);
        assertEquals("Updated Guest Name", updatedGuest.getGuestName());
    }

    @Test
    void testDeleteGuest() {
        doNothing().when(guestRepository).deleteById(1L);
        guestService.deleteGuest(1L);
        verify(guestRepository, times(1)).deleteById(1L);
    }
}
