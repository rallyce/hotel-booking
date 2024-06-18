package com.example.rallyce.booking_service.controller;

import com.example.rallyce.booking_service.domain.dto.BookingRequest;
import com.example.rallyce.booking_service.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> placeBooking(@RequestBody BookingRequest bookingRequest){
        return CompletableFuture.supplyAsync(() -> bookingService.placeBooking(bookingRequest));
    }
}
