package io.github.hotel.reservation.model;

public class Room {
    private String roomNumber;
    private boolean isAvailable;

    public Room(String roomNumber, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.isAvailable = isAvailable;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}