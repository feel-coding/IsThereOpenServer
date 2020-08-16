package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.RestaurantOpenReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantOpenReviewService {
    private final RestaurantOpenReviewRepository restaurantOpenReviewRepository;
    public void putRestaurantOpenReview(Long restaurantSeq, ReqRestaurantOpenReviewCreate reqRestaurantOpenReviewCreate) {
        RestaurantOpenReview restaurantOpenReview = new RestaurantOpenReview();
        restaurantOpenReview.setRestaurantSeq(restaurantSeq);
        restaurantOpenReview.setUserSeq(reqRestaurantOpenReviewCreate.getUserSeq());
        restaurantOpenReview.setOpenState(reqRestaurantOpenReviewCreate.getOpenState());
        restaurantOpenReviewRepository.save(restaurantOpenReview);
    }

    public List<RestaurantOpenReview> getRestaurantOpenReviewList(Long restaurantSeq) {
        return restaurantOpenReviewRepository.findRestaurantOpenReviewBySeq(restaurantSeq);
    }
}
