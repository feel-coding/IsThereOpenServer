package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.CafeOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CafeOpenReviewRepository extends JpaRepository<CafeOpenReview, Integer> {
    int insertCafeOpenReview(CafeOpenReview cafeOpenReview);
    List<CafeOpenReview> findCafeOpenReviewBySeq(@Param("cafeSeq") Integer cafeSeq);
}
