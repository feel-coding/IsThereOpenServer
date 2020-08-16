package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CafeInfoReviewRespository extends JpaRepository<CafeInfoReview,Long> {
    List<CafeInfoReview> findCafeInfoReviewBySeq(Long cafeSeq);
}
