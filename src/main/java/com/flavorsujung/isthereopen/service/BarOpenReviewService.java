package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqBarOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.BarOpenReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarOpenReviewService {
    private final BarOpenReviewRepository barOpenReviewRepository;
    public void putBarOpenReview(Long barSeq, Long userSeq, OpenState openState) {
        BarOpenReview barOpenReview = new BarOpenReview();
        barOpenReview.setBarSeq(barSeq);
        barOpenReview.setUserSeq(userSeq);
        barOpenReview.setOpenState(openState);
        barOpenReviewRepository.save(barOpenReview);
    }

    public List<BarOpenReview> getBarOpenReviewList(Long barSeq) {
        return barOpenReviewRepository.findBarOpenReviewByBarSeq(barSeq);
    }
}
