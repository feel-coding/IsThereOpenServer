package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.RestaurantOpenReviewRepository;
import com.flavorsujung.isthereopen.respository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantOpenReviewService {
    private final RestaurantOpenReviewRepository restaurantOpenReviewRepository;
    private final RestaurantRepository restaurantRepository;

    public void putRestaurantOpenReview(RestaurantOpenReview restaurantOpenReview) {
        restaurantOpenReviewRepository.save(restaurantOpenReview);
        Restaurant restaurant = restaurantRepository.findRestaurantBySeq(restaurantOpenReview.getRestaurantSeq());
        restaurant.setCurrentState(restaurantOpenReview.getOpenState());
        restaurant.setLastUpdate(new Date());
        restaurantRepository.save(restaurant);
    }

    public List<RestaurantOpenReview> getRestaurantOpenReviewList(Long restaurantSeq) {
        List<RestaurantOpenReview> reviewList = restaurantOpenReviewRepository.findRestaurantOpenReviewsByRestaurantSeq(restaurantSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }
}
