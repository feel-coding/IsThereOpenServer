package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantOpenReviewRepository extends JpaRepository<RestaurantOpenReview, Integer> {
    int insertRestaurantOpenReview(RestaurantOpenReview restaurantOpenReview);
    List<RestaurantOpenReview> findRestaurantOpenReviewBySeq(@Param("restaurantSeq") Integer restaurantSeq);
}
