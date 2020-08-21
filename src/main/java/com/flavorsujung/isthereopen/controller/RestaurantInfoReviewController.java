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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.controller.RestaurantController.restaurantMap;

@RestController
@RequiredArgsConstructor
public class RestaurantInfoReviewController {
    private final RestaurantInfoReviewService restaurantInfoReviewService;
    private final RestaurantService restaurantService;

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
        Restaurant restaurant = restaurantService.getRestaurant(restaurantSeq);
        restaurant.setAvgRate(getAvgRate(restaurantSeq));
        restaurantService.postRestaurant(restaurant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantSeq}/infoReview") // 식당 정보 리뷰 리스트 조회 (8/18 API 테스트 완료)
    public List<RestaurantInfoReview> getRestaurantInfoReviewList(@PathVariable("restaurantSeq") Long restaurantSeq) {
        List<RestaurantInfoReview> reviewList =  restaurantInfoReviewService.getRestaurantInfoReviewList(restaurantSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt())); //최신순으로 정렬
        }
        return reviewList;
    }


    @GetMapping("/restaurant/{restaurantSeq}/cleanness")
    public Long countByCleanness(@PathVariable("restaurantSeq") Long restaurantSeq, @RequestParam("cleanness") Cleanness cleanness) {
        return restaurantInfoReviewService.countByCleanness(restaurantSeq, cleanness);
    }

    @GetMapping("/restaurant/{restaurantSeq}/price")
    public Long countByPrice(@PathVariable("restaurantSeq") Long restaurantSeq, @RequestParam("price") Price price) {
        return restaurantInfoReviewService.countByPrice(restaurantSeq, price);
    }

    @GetMapping("/restaurant/{restaurantSeq}/openStyle")
    public Long countByOpenStyle(@PathVariable("restaurantSeq") Long restaurantSeq, @RequestParam("openStyle") OpenStyle openStyle) {
        return restaurantInfoReviewService.countByOpenStyle(restaurantSeq, openStyle);
    }

    @GetMapping("/restaurant/{restaurantSeq}/takeout")
    public Long countByTakeOut(@PathVariable("restaurantSeq") Long restaurantSeq, @RequestParam("takeout") TakeOut takeOut) {
        return restaurantInfoReviewService.countByTakeout(restaurantSeq, takeOut);
    }


    @GetMapping("/restaurant/{restaurantSeq}/waitingTime")
    public Long countByWaitingTime(@PathVariable("restaurantSeq") Long restaurantSeq, @RequestParam("waitingTime") WaitingTime waitingTime) {
        return restaurantInfoReviewService.countByWaitingTime(restaurantSeq, waitingTime);
    }

    @GetMapping("/restaurant/{restaurantSeq}/eatAlone")
    public Long countByEatAlone(@PathVariable("restaurantSeq") Long restaurantSeq, @RequestParam("eatAlone") EatAlone eatAlone) {
        return restaurantInfoReviewService.countByEatAlone(restaurantSeq, eatAlone);
    }

    @GetMapping("/restaurant/{restaurantSeq}/avgRate")
    public Double getAvgRate(@PathVariable("restaurantSeq") Long restaurantSeq) {
        List<RestaurantInfoReview> restaurantInfoReviewList = restaurantInfoReviewService.getRestaurantInfoReviewList(restaurantSeq);
        Double sum = 0.0;
        Long count = restaurantInfoReviewService.countReviews(restaurantSeq);
        for(RestaurantInfoReview review : restaurantInfoReviewList) {
            sum += review.getRate().getRate();
        }
        return sum / count;
    }
}
