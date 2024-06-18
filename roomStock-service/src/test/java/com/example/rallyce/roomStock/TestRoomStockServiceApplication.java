package com.example.rallyce.roomStock;

import org.springframework.boot.SpringApplication;

public class TestRoomStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(RoomStockServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
