package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarInfoReviewRepository extends JpaRepository<BarInfoReview, Integer> {
    int insertBarInfoReview(BarInfoReview barInfoReview);
    List<BarInfoReview> findBarInfoReviewBySeq(@Param("barSeq") Integer barSeq);
}
