package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.domain.req.ReqBarInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.BarInfoReviewRepository;
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
        return barInfoReviewRepository.findBarInfoReviewByBarSeq(barSeq);
    }
}
