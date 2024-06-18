package com.example.rallyce.roomStock.services;

import com.example.rallyce.roomStock.repositories.RoomStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomStockService {

    private final RoomStockRepository roomStockRepository;

    public boolean inStock(String name, Integer quantity){
        return roomStockRepository.existsByNameAndQuantityIsGreaterThanEqual(name, quantity);
    }
}
