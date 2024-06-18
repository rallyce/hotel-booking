package com.example.rallyce.roomStock.repositories;

import com.example.rallyce.roomStock.domain.entities.RoomStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomStockRepository extends JpaRepository<RoomStock, Long> {

    boolean existsByNameAndQuantityIsGreaterThanEqual(String name, Integer quantity);
}
