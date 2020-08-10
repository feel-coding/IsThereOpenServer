package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.CafeOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeOpenReviewRepository extends JpaRepository<User, CafeOpenReview> {
}
