package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqBarOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.BarOpenReviewRepository;
import com.flavorsujung.isthereopen.respository.BarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BarOpenReviewService {
    private final BarOpenReviewRepository barOpenReviewRepository;
    private final BarRepository barRepository;
    public void putBarOpenReview(BarOpenReview barOpenReview) {
        barOpenReviewRepository.save(barOpenReview);
        Bar bar = barRepository.findBarBySeq(barOpenReview.getBarSeq());
        bar.setCurrentState(barOpenReview.getOpenState());
        bar.setLastUpdate(new Date());
        barRepository.save(bar);
    }

    public List<BarOpenReview> getBarOpenReviewList(Long barSeq) {
        List<BarOpenReview> reviewList = barOpenReviewRepository.findBarOpenReviewByBarSeq(barSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }
}
