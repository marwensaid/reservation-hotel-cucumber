package io.github.hotel.reservation.model;

import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private String customerName;
    private String customerEmail;
    private String roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Reservation(String reservationId, String customerName, String customerEmail,
                       String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}