package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.CafeOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqCafeOpenReviewCreate;
import com.flavorsujung.isthereopen.respository.CafeOpenReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeOpenReviewService {
    private final CafeOpenReviewRepository cafeOpenReviewRepository;
    public void putCafeOpenReview(Long cafeSeq, Long userSeq, OpenState openState/*ReqCafeOpenReviewCreate reqCafeOpenReviewCreate*/) {
        CafeOpenReview cafeOpenReview = new CafeOpenReview();
        cafeOpenReview.setCafeSeq(cafeSeq);
//        cafeOpenReview.setUserSeq(reqCafeOpenReviewCreate.getUserSeq());
//        cafeOpenReview.setOpenState(reqCafeOpenReviewCreate.getOpenState());
        cafeOpenReview.setUserSeq(userSeq);
        cafeOpenReview.setOpenState(openState);
        cafeOpenReviewRepository.save(cafeOpenReview);
    }

    public List<CafeOpenReview> getCafeOpenReviewList(Long cafeSeq) {
        return cafeOpenReviewRepository.findCafeOpenReviewBySeq(cafeSeq);
    }
}
