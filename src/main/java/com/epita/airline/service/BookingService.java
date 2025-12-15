package com.epita.airline.service;

import com.epita.airline.dao.BookingDAO;
import com.epita.airline.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    public Booking addBooking(Booking booking) throws Exception {
        // Here you could validate userId and flightId exist before saving
        if (booking.getUserId() == null || booking.getFlightId() == null) {
            throw new Exception("User ID and Flight ID must not be null");
        }

        if (booking.getSeatNumber() == null || booking.getSeatNumber().isEmpty()) {
            throw new Exception("Seat number must not be empty");
        }

        return bookingDAO.save(booking);
    }
    public List<Booking> getAllBookings() {
        return bookingDAO.findAll();
    }

    public Booking getBookingById(Integer id) {
        return bookingDAO.findById(id);
    }
}
