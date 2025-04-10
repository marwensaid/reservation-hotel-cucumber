package io.github.hotel.reservation.service;

import io.github.hotel.reservation.model.Reservation;
import io.github.hotel.reservation.model.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public HotelService() {
        rooms.add(new Room("101", true));
        rooms.add(new Room("102", true));
        rooms.add(new Room("103", true));
    }

    public List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        return rooms.stream().filter(Room::isAvailable).toList();
    }

    public String reserveRoom(String customerName, String customerEmail, String roomNumber, LocalDate checkIn, LocalDate checkOut) {
        Optional<Room> room = rooms.stream().filter(r -> r.getRoomNumber().equals(roomNumber) && r.isAvailable()).findFirst();
        if (room.isPresent()) {
            room.get().setAvailable(false);
            String reservationId = UUID.randomUUID().toString();
            reservations.add(new Reservation(reservationId, customerName, customerEmail, roomNumber, checkIn, checkOut));
            return reservationId;
        }
        return null;
    }

    public boolean cancelReservation(String reservationId) {
        Optional<Reservation> reservation = reservations.stream().filter(r -> r.getReservationId().equals(reservationId)).findFirst();
        if (reservation.isPresent()) {
            reservations.remove(reservation.get());
            rooms.stream().filter(r -> r.getRoomNumber().equals(reservation.get().getRoomNumber())).forEach(r -> r.setAvailable(true));
            return true;
        }
        return false;
    }

    public Reservation getReservation(String reservationId) {
        return reservations.stream().filter(r -> r.getReservationId().equals(reservationId)).findFirst().orElse(null);
    }
}