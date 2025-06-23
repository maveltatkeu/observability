package com.mavelt.orderservice.controllers;

import com.mavelt.orderservice.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/api/v1.1/orders")
public class OrderController {

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id) {
        int result = this.getRandomNumber(1, 6);
        log.info("Anonymous Customer is ordering {} items of: {}", result,id);
        return new Order(id, 1L, ZonedDateTime.now(), BigDecimal.TEN);
    }

    public int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
