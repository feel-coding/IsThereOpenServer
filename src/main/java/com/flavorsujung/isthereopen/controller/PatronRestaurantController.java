package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.PatronRestaurant;
import com.flavorsujung.isthereopen.service.PatronRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class PatronRestaurantController {
    private final PatronRestaurantService patronRestaurantService;

    @GetMapping("/user/{seq}/patronRestaurant/all") //단골식당 리스트 조회
    public List<PatronRestaurant> getPatronRestaurantList(@PathVariable("seq") Long userSeq) {
        return patronRestaurantService.getPatronRestaurantList(userSeq);
    }

    @PutMapping("/user/{seq}/patronRestaurant") //단골 식당 추가
    public void putPatronRestaurant(@PathVariable("seq") Long userSeq, @RequestParam("restaurantSeq") Long restaurantSeq) {
        patronRestaurantService.putPatronRestaurant(userSeq, restaurantSeq);
    }

    @DeleteMapping("/user/{seq}/patronRestaurant")
    public void deletePatronRestaurant(@PathVariable("seq") Long userSeq, @RequestParam("restaurantSeq") Long restaurantSeq) {
        patronRestaurantService.deletePatronRestaurant(userSeq, restaurantSeq);
    }
}
