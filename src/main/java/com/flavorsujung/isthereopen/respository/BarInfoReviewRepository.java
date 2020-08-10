package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarInfoReviewRepository extends JpaRepository<User, BarInfoReview> {
}
