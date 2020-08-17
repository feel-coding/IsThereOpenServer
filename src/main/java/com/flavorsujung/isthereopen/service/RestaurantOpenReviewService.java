package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.RestaurantOpenReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantOpenReviewService {
    private final RestaurantOpenReviewRepository restaurantOpenReviewRepository;
    public void putRestaurantOpenReview(Long restaurantSeq, Long userSeq, OpenState openState) {
        RestaurantOpenReview restaurantOpenReview = new RestaurantOpenReview();
        restaurantOpenReview.setRestaurantSeq(restaurantSeq);
        restaurantOpenReview.setUserSeq(userSeq);
        restaurantOpenReview.setOpenState(openState);
        restaurantOpenReviewRepository.save(restaurantOpenReview);
    }

    public List<RestaurantOpenReview> getRestaurantOpenReviewList(Long restaurantSeq) {
        return restaurantOpenReviewRepository.findRestaurantOpenReviewsByRestaurantSeq(restaurantSeq);
    }
}
