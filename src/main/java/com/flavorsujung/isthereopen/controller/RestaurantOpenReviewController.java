package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantOpenReviewCreate;
import com.flavorsujung.isthereopen.service.RestaurantOpenReviewService;
import com.flavorsujung.isthereopen.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

import static com.flavorsujung.isthereopen.controller.RestaurantController.*;

@RestController
@RequiredArgsConstructor
public class RestaurantOpenReviewController {
    private final RestaurantOpenReviewService restaurantOpenReviewService;

    @PostConstruct
    public void init(){

    }


    @PutMapping("/restaurant/openReview")//식당 오픈리뷰 작성
    public ResponseEntity<Void> createRestaurantOpenReview(@RequestBody RestaurantOpenReview restaurantOpenReview) {
        restaurantOpenReviewService.putRestaurantOpenReview(restaurantOpenReview);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/restaurant/{restaurantSeq}/openReview") //특정 식당의 오픈리뷰들 가져오기
    public List<RestaurantOpenReview> getRestaurantOpenReviewList(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantOpenReviewService.getRestaurantOpenReviewList(restaurantSeq);
    }

}
