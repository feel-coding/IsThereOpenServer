package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
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
    private final RestaurantService restaurantService;
    public static Map<Integer, RestaurantOpenReview> restaurantOpenReviewMap;

    @PostConstruct
    public void init(){
        restaurantOpenReviewMap = new HashMap<>();
    }


    @PutMapping("/restaurant/{restaurantSeq}/openReview")
    public ResponseEntity<Void> putRestaurantOpenReview( //사용자가 오픈리뷰 작성 (API 테스트 완료)
                                                         @PathVariable("restaurantSeq") Integer restaurantSeq, @RequestBody ReqRestaurantOpenReviewCreate reqRestaurantOpenReviewCreate) {
//        int seq = restaurantOpenReviewMap.size();
//        restaurantOpenReviewMap.put(seq, new RestaurantOpenReview(seq, restaurantSeq, userSeq, openState));
//        restaurantMap.get(restaurantSeq).getRestaurantOpenReviewList().add(new RestaurantOpenReview(seq, restaurantSeq, userSeq, openState));
//        restaurantMap.get(restaurantSeq).setCurrentState(openState); //식당 테이블의 현재 상태 업데이트
//        restaurantMap.get(restaurantSeq).setLastUpdate(new Date());
        restaurantOpenReviewService.putRestaurantOpenReview(restaurantSeq, reqRestaurantOpenReviewCreate);
        restaurantService.getRestaurant(restaurantSeq).setCurrentState(reqRestaurantOpenReviewCreate.getOpenState());
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/restaurant/{restaurantSeq}/openReview") //특정 식당의 오픈리뷰들 가져오기 (API 테스트 완료)
    public List<RestaurantOpenReview> getRestaurantOpenReviewList(@PathVariable("restaurantSeq") Integer restaurantSeq) {
//        return restaurantMap.get(restaurantSeq).getRestaurantOpenReviewList();
        return restaurantOpenReviewService.getRestaurantOpenReviewList(restaurantSeq);
    }

//    @GetMapping("/restaurant/{restaurantSeq}/openReview/{openReviewSeq}") //특정 식당의 몇 번째 오픈리뷰 가져오기 (API 테스트 완료)
//    public RestaurantOpenReview getRestaurantOpenReview(@PathVariable("restaurantSeq") Integer restaurantSeq, @PathVariable("openReviewSeq") Integer openReviewSeq) {
//        return restaurantMap.get(restaurantSeq).getRestaurantOpenReviewList().get(openReviewSeq);
//    }
}
