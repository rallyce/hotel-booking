package com.example.rallyce.booking_service.repositories;

import com.example.rallyce.booking_service.domain.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
