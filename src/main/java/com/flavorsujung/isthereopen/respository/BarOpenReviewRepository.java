package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarOpenReviewRepository extends JpaRepository<User, BarOpenReview > {
}
