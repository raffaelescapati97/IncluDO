package com.includo.repository;

import java.util.ArrayList;

import com.includo.model.Booking;

public class BookingRepository {

    private ArrayList<Booking> bookings;

    public BookingRepository() {
        bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public Booking findById(int id) {

        for (Booking booking : bookings) {

            if (booking.getId() == id) {
                return booking;
            }

        }

        return null;
    }
    
    public int getNextId() {

        int max = 0;

        for (Booking booking : bookings) {

            if (booking.getId() > max) {
                max = booking.getId();
            }

        }

        return max + 1;
    }
}