package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.RestaurantController.*;

@RestController
public class RestaurantOpenReviewController {
    public static Map<Integer, RestaurantOpenReview> restaurantOpenReviewMap;

    @PostConstruct
    public void init(){
        restaurantOpenReviewMap = new HashMap<>();
    }


    @PutMapping("/restaurant/{restaurantSeq}/openReview")
    public void putRestaurantOpenReview( //사용자가 오픈리뷰 작성 (API 테스트 완료)
            @PathVariable("restaurantSeq") Integer restaurantSeq,
            @RequestParam("userSeq") Integer userSeq,
            @RequestParam("openState") Integer openState) {
        int seq = restaurantOpenReviewMap.size();
        restaurantOpenReviewMap.put(seq, new RestaurantOpenReview(seq, restaurantSeq, userSeq, openState));
        restaurantMap.get(restaurantSeq).getRestaurantOpenReviewList().add(new RestaurantOpenReview(seq, restaurantSeq, userSeq, openState));
        restaurantMap.get(restaurantSeq).setCurrentState(openState); //식당 테이블 업데이트
    }

    @GetMapping("/restaurant/{restaurantSeq}/openReview") //특정 식당의 오픈리뷰들 가져오기
    public List<RestaurantOpenReview> getRestaurantOpenReviewList(@PathVariable("restaurantSeq") Integer restaurantSeq) {
        return restaurantMap.get(restaurantSeq).getRestaurantOpenReviewList();
    }

    @GetMapping("/restaurant/{restaurantSeq}/openReview/{openReviewSeq}") //특정 식당의 몇 번째 오픈리뷰 가져오기
    public RestaurantOpenReview getRestaurantOpenReview(@PathVariable("restaurantSeq") Integer restaurantSeq, @PathVariable("openReviewSeq") Integer openReviewSeq) {
        return restaurantMap.get(restaurantSeq).getRestaurantOpenReviewList().get(openReviewSeq);
    }
}
