package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.RestaurantInfoReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantInfoReviewService {
    private final RestaurantInfoReviewRepository restaurantInfoReviewRepository;

    public void putRestaurantInfoReview(Integer restaurantSeq, ReqRestaurantInfoReviewCreate reqRestaurantInfoReviewCreate) {
        RestaurantInfoReview restaurantInfoReview = new RestaurantInfoReview();
        restaurantInfoReview.setSeq(restaurantSeq);
        restaurantInfoReview.setOpenStyle(reqRestaurantInfoReviewCreate.getOpenStyle());
        restaurantInfoReview.setCleanness(reqRestaurantInfoReviewCreate.getCleanness());
        restaurantInfoReview.setEatAlone(reqRestaurantInfoReviewCreate.getEatAlone());
        restaurantInfoReview.setPrice(reqRestaurantInfoReviewCreate.getPrice());
        restaurantInfoReview.setTakeOut(reqRestaurantInfoReviewCreate.getTakeOut());
        restaurantInfoReview.setWaitingTime(reqRestaurantInfoReviewCreate.getWaitingTime());
        restaurantInfoReview.setUserSeq(reqRestaurantInfoReviewCreate.getUserSeq());
        restaurantInfoReviewRepository.save(restaurantInfoReview);
    }

    public List<RestaurantInfoReview> getRestaurantInfoReviewList(Integer restaurantSeq) {
        return restaurantInfoReviewRepository.findRestaurantInfoReviewBySeq(restaurantSeq);
    }
}
