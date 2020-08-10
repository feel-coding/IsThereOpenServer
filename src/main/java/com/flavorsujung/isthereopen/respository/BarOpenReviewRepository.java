package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarOpenReviewRepository extends JpaRepository<BarOpenReview ,Integer> {
    int insertBarOpenReview(BarOpenReview barOpenReview);
    List<BarOpenReview> findBarOpenReviewBySeq(@Param("barSeq") Integer barSeq);
}
