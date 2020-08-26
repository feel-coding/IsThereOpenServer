package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.service.RestaurantInfoReviewService;
import com.flavorsujung.isthereopen.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.Convert;
import java.util.*;

import static com.flavorsujung.isthereopen.controller.RestaurantController.restaurantMap;

@RestController
@RequiredArgsConstructor
public class RestaurantInfoReviewController {
    private final RestaurantInfoReviewService restaurantInfoReviewService;

    @PostConstruct
    public void init() {

    }

    @PutMapping("/restaurant/infoReview") // 식당 정보 리뷰 작성
    public ResponseEntity<Void> createRestaurantInfoReviewList(@RequestBody RestaurantInfoReview restaurantInfoReview) {
        restaurantInfoReviewService.putRestaurantInfoReview(restaurantInfoReview);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantSeq}/infoReview") // 식당 정보 리뷰 리스트 조회
    public List<RestaurantInfoReview> getRestaurantInfoReviewList(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getRestaurantInfoReviewList(restaurantSeq);
    }


    @GetMapping("/restaurant/{restaurantSeq}/cleanness")
    public List<String> getAvgCleanness(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getAvgCleanness(restaurantSeq);
    }

    @GetMapping("/restaurant/{restaurantSeq}/price")
    public List<String> getAvgPrice(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getAvgPrice(restaurantSeq);
    }

    @GetMapping("/restaurant/{restaurantSeq}/openStyle")
    public List<String> getAvgOpenStyle(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getAvgOpenStyle(restaurantSeq);
    }


    @GetMapping("/restaurant/{restaurantSeq}/takeout")
    public List<String> getAvgTakeOut(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getAvgTakeout(restaurantSeq);
    }


    @GetMapping("/restaurant/{restaurantSeq}/waitingTime")
    public List<String> getAvgWaitingTime(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getAvgWaitingTime(restaurantSeq);
    }

    @GetMapping("/restaurant/{restaurantSeq}/eatAlone")
    public List<String> getAvgEatAlone(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getAvgEatAlone(restaurantSeq);
    }

    @GetMapping("/restaurant/{restaurantSeq}/avgRate")
    public Double getAvgRate(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantInfoReviewService.getAvgRate(restaurantSeq);
    }
}
