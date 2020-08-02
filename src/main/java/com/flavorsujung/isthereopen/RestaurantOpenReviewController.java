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
        restaurantOpenReviewMap.put(1, new RestaurantOpenReview(1, 1, 2, CLOSE));
        restaurantOpenReviewMap.put(2, new RestaurantOpenReview(2, 2, 1, UNKNOWN));
    }

    @GetMapping("/restaurantOpenReview/{seq}")
    public RestaurantOpenReview getRestaurantOpenReview(@PathVariable("seq") Integer seq) {
        return restaurantOpenReviewMap.get(seq);
    }

    @GetMapping("/restaurantOpenReview/all")
    public List<RestaurantOpenReview> getRestaurantOpenReviewList() {
        return new ArrayList<RestaurantOpenReview>(restaurantOpenReviewMap.values());
    }

    @PutMapping("/restaurantOpenReview")
    public void putRestaurantOpenReview(@RequestParam("restaurantSeq") Integer restaurantSeq, @RequestParam("userSeq") Integer userSeq, @RequestParam("openState") Integer openState) {
        int seq = restaurantOpenReviewMap.size();
        RestaurantOpenReview openReview = new RestaurantOpenReview(seq, restaurantSeq, userSeq, openState);
        restaurantOpenReviewMap.put(seq, openReview);
        restaurantMap.get(restaurantSeq).setCurrentState(openState);
    }
}
