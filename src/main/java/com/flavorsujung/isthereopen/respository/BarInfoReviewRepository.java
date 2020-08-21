package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarInfoReviewRepository extends JpaRepository<BarInfoReview, Long> {
    List<BarInfoReview> findBarInfoReviewsByBarSeq(Long barSeq);

    Long countByBarSeqAndToilet(Long barSeq, Toilet toilet);

    Long countByBarSeqAndMood(Long barSeq, Mood mood);

    Long countByBarSeqAndCleanness(Long barSeq, Cleanness cleanness);

    Long countByBarSeqAndMainAlcohol(Long barSeq, Alcohol alcohol);

    Long countByBarSeqAndOpenStyle(Long barSeq, OpenStyle openStyle);

    Long countByBarSeqAndPrice(Long barSeq, Price price);

    Long countByBarSeq(Long barSeq);
}
