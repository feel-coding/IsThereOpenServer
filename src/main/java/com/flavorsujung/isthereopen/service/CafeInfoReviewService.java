package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.req.ReqBarInfoReviewCreate;
import com.flavorsujung.isthereopen.domain.req.ReqCafeInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.CafeInfoReviewRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeInfoReviewService {
    private final CafeInfoReviewRespository cafeInfoReviewRepository;

    public void putCafeInfoReview(Long cafeSeq, ReqCafeInfoReviewCreate reqCafeInfoReviewCreate) {
        CafeInfoReview cafeInfoReview = new CafeInfoReview();
        cafeInfoReview.setCafeSeq(cafeSeq);
        cafeInfoReview.setCustomerNum(reqCafeInfoReviewCreate.getCustomerNum());
        cafeInfoReview.setOpenStyle(reqCafeInfoReviewCreate.getOpenStyle());
        cafeInfoReview.setPrice(reqCafeInfoReviewCreate.getPrice());
        cafeInfoReview.setPlugNum(reqCafeInfoReviewCreate.getPlugNum());
        cafeInfoReview.setLongStay(reqCafeInfoReviewCreate.getLongStay());
        cafeInfoReview.setTableHeight(reqCafeInfoReviewCreate.getTableHeight());
        cafeInfoReview.setWaitingTime(reqCafeInfoReviewCreate.getWaitingTime());
        cafeInfoReview.setUserSeq(reqCafeInfoReviewCreate.getUserSeq());
        cafeInfoReviewRepository.save(cafeInfoReview);
    }

    public List<CafeInfoReview> getCafeInfoReviewList(Long cafeSeq) {
        return cafeInfoReviewRepository.findCafeInfoReviewBySeq(cafeSeq);
    }
}
