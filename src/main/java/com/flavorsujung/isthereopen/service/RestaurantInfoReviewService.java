package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.domain.req.ReqRestaurantInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.RestaurantInfoReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantInfoReviewService {
    private final RestaurantInfoReviewRepository restaurantInfoReviewRepository;

    public void putRestaurantInfoReview(
            Long restaurantSeq, Long userSeq, Rate rate,
            WaitingTime waitingTime, Cleanness cleanness,
            Price price, TakeOut takeOut, EatAlone eatAlone, OpenStyle openStyle) {
        RestaurantInfoReview restaurantInfoReview = new RestaurantInfoReview();
        restaurantInfoReview.setRestaurantSeq(restaurantSeq);
        restaurantInfoReview.setOpenStyle(openStyle);
        restaurantInfoReview.setCleanness(cleanness);
        restaurantInfoReview.setEatAlone(eatAlone);
        restaurantInfoReview.setPrice(price);
        restaurantInfoReview.setTakeOut(takeOut);
        restaurantInfoReview.setWaitingTime(waitingTime);
        restaurantInfoReview.setUserSeq(userSeq);
        restaurantInfoReview.setRate(rate);
        restaurantInfoReviewRepository.save(restaurantInfoReview);
    }

    public List<RestaurantInfoReview> getRestaurantInfoReviewList(Long restaurantSeq) {
        return restaurantInfoReviewRepository.findRestaurantInfoReviewBySeq(restaurantSeq);
    }
}
