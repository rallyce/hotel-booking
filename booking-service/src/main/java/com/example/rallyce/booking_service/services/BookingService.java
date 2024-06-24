package com.example.rallyce.booking_service.services;

import com.example.rallyce.booking_service.client.StockClient;
import com.example.rallyce.booking_service.domain.dto.BookingRequest;
import com.example.rallyce.booking_service.domain.dto.BookingResponse;
import com.example.rallyce.booking_service.domain.entities.Booking;
import com.example.rallyce.booking_service.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final StockClient stockClient;

    public String placeBooking(BookingRequest bookingRequest){

        boolean bookingInStock = stockClient.inStock(bookingRequest.name(), bookingRequest.quantity());

        if (bookingInStock) {
            Booking booking = new Booking();
            booking.setBookingNumber(UUID.randomUUID().toString());
            booking.setName(bookingRequest.name());
            booking.setEmail(bookingRequest.email());
            booking.setPhone(bookingRequest.phone());
            booking.setQuantity(bookingRequest.quantity());

            bookingRepository.save(booking);
            return "Booking placed successfully";
        }

        else {
            throw new RuntimeException("Booking with name " + bookingRequest.name() + " not available at the moment");
        }
    }

    public List<BookingResponse> listBookings(){

        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream().map(booking -> new BookingResponse(booking.getId(), booking.getBookingNumber(),
                booking.getName(), booking.getEmail(), booking.getPhone(), booking.getQuantity())).toList();
    }

}
