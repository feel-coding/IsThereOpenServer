package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantInfoReviewRepository extends JpaRepository<User, RestaurantInfoReview> {
}
