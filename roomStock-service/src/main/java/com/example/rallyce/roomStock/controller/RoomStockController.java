package com.example.rallyce.roomStock.controller;

import com.example.rallyce.roomStock.services.RoomStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class RoomStockController {

    private final RoomStockService roomStockService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean inStock(@RequestParam String name, @RequestParam Integer quantity){
       return roomStockService.inStock(name, quantity);
    }

}
