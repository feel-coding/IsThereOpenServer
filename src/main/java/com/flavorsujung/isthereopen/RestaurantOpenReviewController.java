package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestaurantOpenReviewController {
    private Integer seq = 0;
    public static Map<Integer, RestaurantOpenReview> restaurantOpenReviewMap;
}
