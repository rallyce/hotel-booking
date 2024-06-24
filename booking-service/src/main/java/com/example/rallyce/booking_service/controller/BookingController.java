package com.example.rallyce.booking_service.controller;

import com.example.rallyce.booking_service.domain.dto.BookingRequest;
import com.example.rallyce.booking_service.domain.dto.BookingResponse;
import com.example.rallyce.booking_service.domain.entities.Booking;
import com.example.rallyce.booking_service.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin("http://localhost:5173/")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> placeBooking(@RequestBody BookingRequest bookingRequest){
        return CompletableFuture.supplyAsync(() -> bookingService.placeBooking(bookingRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookingResponse> listBookings(){

        return bookingService.listBookings();
    }
}
