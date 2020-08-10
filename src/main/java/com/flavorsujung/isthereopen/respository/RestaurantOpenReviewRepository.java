package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantOpenReviewRepository extends JpaRepository<User, RestaurantOpenReview> {
}
