package com.example.rallyce.booking_service.domain.dto;

public record BookingRequest (String bookingNumber, String name, String email, String phone, Integer quantity){
}
