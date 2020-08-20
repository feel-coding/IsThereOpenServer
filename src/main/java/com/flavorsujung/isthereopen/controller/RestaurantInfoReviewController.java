package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantInfoReviewCreate;
import com.flavorsujung.isthereopen.service.RestaurantInfoReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.Convert;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.controller.RestaurantController.restaurantMap;

@RestController
@RequiredArgsConstructor
public class RestaurantInfoReviewController {
    private final RestaurantInfoReviewService restaurantInfoReviewService;
//    Map<Integer, RestaurantInfoReview> restaurantInfoReviewMap;

    @PostConstruct
    public void init() {
//        restaurantInfoReviewMap = new HashMap<>();
    }

    @PutMapping("/restaurant/{restaurantSeq}/infoReview") // 식당 정보 리뷰 작성 (8/18 API 테스트 완료)
    public ResponseEntity<Void> putRestaurantInfoReviewList(
            @PathVariable("restaurantSeq") Long restaurantSeq,
            @RequestParam("userSeq") Long userSeq,
            @RequestParam("rate") Rate rate,
            @RequestParam("waitingTime") WaitingTime waitingTime,
            @RequestParam("cleanness") Cleanness cleanness,
            @RequestParam("price") Price price,
            @RequestParam("takeOut") TakeOut takeOut,
            @RequestParam("eatAlone") EatAlone eatAlone,
            @RequestParam("openStyle") OpenStyle openStyle) {
        restaurantInfoReviewService.putRestaurantInfoReview(restaurantSeq,userSeq, rate, waitingTime, cleanness, price, takeOut, eatAlone, openStyle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantSeq}/infoReview") // 식당 정보 리뷰 리스트 조회 (8/18 API 테스트 완료)
    public List<RestaurantInfoReview> getRestaurantInfoReviewList(@PathVariable("restaurantSeq") Long restaurantSeq) {
//        return restaurantMap.get(restaurantSeq).getRestaurantInfoReviewList();
        List<RestaurantInfoReview> reviewList =  restaurantInfoReviewService.getRestaurantInfoReviewList(restaurantSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }

//    @GetMapping("/restaurant/{restaurantSeq}/infoReview/{infoReviewSeq}") //특정 식당의 몇 번째 리뷰 가져오기 (API 테스트 완료)
//    public RestaurantInfoReview getRestaurantInfoReview(@PathVariable("restaurantSeq") Integer restaurantSeq, @PathVariable("infoReviewSeq") Integer infoReviewSeq) {
//        return restaurantMap.get(restaurantSeq).getRestaurantInfoReviewList().get(infoReviewSeq);
//    }
}
