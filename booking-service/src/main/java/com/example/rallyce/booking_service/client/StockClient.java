package com.example.rallyce.booking_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "roomstock", url = "${roomstock.url}")
public interface StockClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/stock")
    boolean inStock(@RequestParam String name, @RequestParam Integer quantity);
}
