package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantInfoReviewCreate;
import com.flavorsujung.isthereopen.service.RestaurantInfoReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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
    @PutMapping("/restaurant/{restaurantSeq}/infoReview")
    public ResponseEntity<Void> putRestaurantInfoReview( //식당 리뷰 추가 (API 테스트 완료)
                                                         @PathVariable("restaurantSeq")Long restaurantSeq, @RequestBody ReqRestaurantInfoReviewCreate reqRestaurantInfoReviewCreate) {
//        int seq = restaurantInfoReviewMap.size();
//        RestaurantInfoReview restaurantInfoReview = new RestaurantInfoReview(seq, restaurantSeq, openStyle, waitingTime, cleanness, price, takeOut, eatAlone);
//        restaurantInfoReviewMap.put(seq,restaurantInfoReview);
//        restaurantMap.get(restaurantSeq).getRestaurantInfoReviewList().add(restaurantInfoReview);
        restaurantInfoReviewService.putRestaurantInfoReview(restaurantSeq, reqRestaurantInfoReviewCreate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantSeq}/infoReview") //특정 식당의 리뷰들 가져오기 (API 테스트 완료)
    public List<RestaurantInfoReview> getRestaurantInfoReviewList(@PathVariable("restaurantSeq") Long restaurantSeq) {
//        return restaurantMap.get(restaurantSeq).getRestaurantInfoReviewList();
        return restaurantInfoReviewService.getRestaurantInfoReviewList(restaurantSeq);
    }

//    @GetMapping("/restaurant/{restaurantSeq}/infoReview/{infoReviewSeq}") //특정 식당의 몇 번째 리뷰 가져오기 (API 테스트 완료)
//    public RestaurantInfoReview getRestaurantInfoReview(@PathVariable("restaurantSeq") Integer restaurantSeq, @PathVariable("infoReviewSeq") Integer infoReviewSeq) {
//        return restaurantMap.get(restaurantSeq).getRestaurantInfoReviewList().get(infoReviewSeq);
//    }
}
