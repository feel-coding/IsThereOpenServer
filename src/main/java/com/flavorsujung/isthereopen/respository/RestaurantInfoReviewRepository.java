package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantInfoReviewRepository extends JpaRepository<RestaurantInfoReview, Long> {
    List<RestaurantInfoReview> findRestaurantInfoReviewByRestaurantSeq(Long restaurantSeq);

    Long countByRestaurantSeqAndOpenStyle(Long restaurantSeq, OpenStyle openStyle);

    Long countByRestaurantSeqAndPrice(Long restaurantSeq, Price price);

    Long countByRestaurantSeqAndTakeOut(Long restaurantSeq, TakeOut takeOut);

    Long countByRestaurantSeqAndEatAlone(Long restaurantSeq, EatAlone eatAlone);

    Long countByRestaurantSeqAndWaitingTime(Long restaurantSeq, WaitingTime waitingTime);

    Long countByRestaurantSeqAndCleanness(Long restaurantSeq, Cleanness cleanness);

    Long countByRestaurantSeq(Long restaurantSeq);
}
