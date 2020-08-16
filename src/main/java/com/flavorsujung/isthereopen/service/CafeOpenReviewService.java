package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.CafeOpenReview;
import com.flavorsujung.isthereopen.domain.req.ReqCafeOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.CafeOpenReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeOpenReviewService {
    private final CafeOpenReviewRepository cafeOpenReviewRepository;
    public void putCafeOpenReview(Integer cafeSeq, ReqCafeOpenReviewCreate reqCafeOpenReviewCreate) {
        CafeOpenReview cafeOpenReview = new CafeOpenReview();
        cafeOpenReview.setCafeSeq(cafeSeq);
        cafeOpenReview.setUserSeq(reqCafeOpenReviewCreate.getUserSeq());
        cafeOpenReview.setOpenState(reqCafeOpenReviewCreate.getOpenState());
        cafeOpenReview.setLastUpdate(reqCafeOpenReviewCreate.getLastUpdate());
        cafeOpenReviewRepository.save(cafeOpenReview);
    }

    public List<CafeOpenReview> getCafeOpenReviewList(Integer cafeSeq) {
        return cafeOpenReviewRepository.findCafeOpenReviewBySeq(cafeSeq);
    }
}
