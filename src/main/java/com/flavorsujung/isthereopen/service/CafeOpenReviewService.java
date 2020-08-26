package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.entity.CafeOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqCafeOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.CafeOpenReviewRepository;
import com.flavorsujung.isthereopen.respository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeOpenReviewService {
    private final CafeOpenReviewRepository cafeOpenReviewRepository;
    private final CafeRepository cafeRepository;
    public void putCafeOpenReview(CafeOpenReview cafeOpenReview/*Long cafeSeq, Long userSeq, OpenState openState*/) {
        /*CafeOpenReview cafeOpenReview = new CafeOpenReview();
        cafeOpenReview.setCafeSeq(cafeSeq);
        cafeOpenReview.setUserSeq(userSeq);
        cafeOpenReview.setOpenState(openState);*/
        cafeOpenReviewRepository.save(cafeOpenReview);
        Cafe cafe = cafeRepository.findCafeBySeq(cafeOpenReview.getCafeSeq());
        cafe.setCurrentState(cafeOpenReview.getOpenState());
        cafe.setLastUpdate(new Date());
        cafeRepository.save(cafe);
    }

    public List<CafeOpenReview> getCafeOpenReviewList(Long cafeSeq) {
        List<CafeOpenReview> reviewList = cafeOpenReviewRepository.findCafeOpenReviewByCafeSeq(cafeSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }
}
