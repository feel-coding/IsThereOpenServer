package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantInfoReviewRepository extends JpaRepository<RestaurantInfoReview, Integer> {
    int insertRestaurantInfoReview(RestaurantInfoReview restaurantInfoReview);
    List<RestaurantInfoReview> findRestaurantInfoReviewBySeq(@Param("restaurantSeq") Integer restaurantSeq);
}
