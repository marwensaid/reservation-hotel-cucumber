package io.github.hotel.reservation.controller;

import io.github.hotel.reservation.model.Reservation;
import io.github.hotel.reservation.model.Room;
import io.github.hotel.reservation.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/rooms")
    public List<Room> getAvailableRooms(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {
        return hotelService.findAvailableRooms(checkIn, checkOut);
    }

    @PostMapping("/reserve")
    public String reserveRoom(@RequestParam String customerName,
                              @RequestParam String customerEmail,
                              @RequestParam String roomNumber,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {
        return hotelService.reserveRoom(customerName, customerEmail, roomNumber, checkIn, checkOut);
    }

    @DeleteMapping("/cancel/{reservationId}")
    public boolean cancelReservation(@PathVariable String reservationId) {
        return hotelService.cancelReservation(reservationId);
    }

    @GetMapping("/reservation/{reservationId}")
    public Reservation getReservation(@PathVariable String reservationId) {
        return hotelService.getReservation(reservationId);
    }
}