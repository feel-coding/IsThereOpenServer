package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.req.ReqBarOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.BarOpenReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarOpenReviewService {
    private final BarOpenReviewRepository barOpenReviewRepository;
    public void putBarOpenReview(Integer barSeq, ReqBarOpenReviewCreate reqBarOpenReviewCreate) {
        BarOpenReview barOpenReview = new BarOpenReview();
        barOpenReview.setBarSeq(barSeq);
        barOpenReview.setUserSeq(reqBarOpenReviewCreate.getUserSeq());
        barOpenReview.setOpenState(reqBarOpenReviewCreate.getOpenState());
        barOpenReview.setLastUpdate(reqBarOpenReviewCreate.getLastUpdate());
        int insertCount = barOpenReviewRepository.insertBarOpenReview(barOpenReview);
    }

    public List<BarOpenReview> getBarOpenReviewList(Integer barSeq) {
        return barOpenReviewRepository.findBarOpenReviewBySeq(barSeq);
    }
}