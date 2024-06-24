package com.example.rallyce.booking_service.domain.dto;

public record BookingResponse (Long id ,String bookingNumber, String name, String email, String phone, Integer quantity){
}
