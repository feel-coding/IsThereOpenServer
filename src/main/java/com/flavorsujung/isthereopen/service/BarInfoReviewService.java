package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.domain.req.ReqBarInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.BarInfoReviewRepository;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarInfoReviewService {
    private final BarInfoReviewRepository barInfoReviewRepository;

    public void putBarInfoReview(
            Long barSeq, Long userSeq, Rate rate, Toilet toilet,
            Mood mood, Alcohol mainAlcohol, Price price, Cleanness cleanness, OpenStyle openStyle) {
        BarInfoReview barInfoReview = new BarInfoReview();
        barInfoReview.setBarSeq(barSeq);
        barInfoReview.setUserSeq(userSeq);
        barInfoReview.setCleanness(cleanness);
        barInfoReview.setToilet(toilet);
        barInfoReview.setRate(rate);
        barInfoReview.setMood(mood);
        barInfoReview.setOpenStyle(openStyle);
        barInfoReview.setPrice(price);
        barInfoReview.setMainAlcohol(mainAlcohol);
        barInfoReviewRepository.save(barInfoReview);
    }

    public List<BarInfoReview> getBarInfoReviewList(Long barSeq) {
        return barInfoReviewRepository.findBarInfoReviewsByBarSeq(barSeq);
    }

    public Long countByToilet(Long barSeq, Toilet toilet) {
        return barInfoReviewRepository.countByBarSeqAndToilet(barSeq, toilet);
    }

    public Long countByOpenStyle(Long barSeq, OpenStyle openStyle) {
        return barInfoReviewRepository.countByBarSeqAndOpenStyle(barSeq, openStyle);
    }

    public Long countByAlcohol(Long barSeq, Alcohol alcohol) {
        return barInfoReviewRepository.countByBarSeqAndMainAlcohol(barSeq, alcohol);
    }

    public Long countByMood(Long barSeq, Mood mood) {
        return barInfoReviewRepository.countByBarSeqAndMood(barSeq, mood);
    }

    public Long countByPrice(Long barSeq, Price price) {
        return barInfoReviewRepository.countByBarSeqAndPrice(barSeq, price);
    }

    public Long countByCleanness(Long barSeq,Cleanness cleanness) {
        return barInfoReviewRepository.countByBarSeqAndCleanness(barSeq, cleanness);

    }

    public Long countReview(Long barSeq) {
        return barInfoReviewRepository.countByBarSeq(barSeq);
    }
}