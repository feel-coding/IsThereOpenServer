package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.respository.CafeInfoReviewRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeInfoReviewService {
    private final CafeInfoReviewRespository cafeInfoReviewRepository;

    public void putCafeInfoReview(
            Long cafeSeq, Long userSeq, OpenStyle openStyle,
            WaitingTime waitingTime, Price price, CustomerNum customerNum,
            PlugNum plugNum, Rate rate, TableHeight tableHeight,
            Lightness lightness, StayLong stayLong) {
        CafeInfoReview cafeInfoReview = new CafeInfoReview();
        cafeInfoReview.setCafeSeq(cafeSeq);
        cafeInfoReview.setCustomerNum(customerNum);
        cafeInfoReview.setOpenStyle(openStyle);
        cafeInfoReview.setPrice(price);
        cafeInfoReview.setPlugNum(plugNum);
        cafeInfoReview.setRate(rate);
        cafeInfoReview.setStayLong(stayLong);
        cafeInfoReview.setTableHeight(tableHeight);
        cafeInfoReview.setWaitingTime(waitingTime);
        cafeInfoReview.setUserSeq(userSeq);
        cafeInfoReview.setLightness(lightness);
        cafeInfoReviewRepository.save(cafeInfoReview);
    }

    public List<CafeInfoReview> getCafeInfoReviewList(Long cafeSeq) {
        return cafeInfoReviewRepository.findCafeInfoReviewByCafeSeq(cafeSeq);
    }

    public Long countByOpenStyle(Long cafeSeq, OpenStyle openStyle) {
        return cafeInfoReviewRepository.countByCafeSeqAndOpenStyle(cafeSeq, openStyle);
    }

    public Long countByWaitingTime(Long cafeSeq, WaitingTime waitingTime) {
        return cafeInfoReviewRepository.countByCafeSeqAndWaitingTime(cafeSeq, waitingTime);
    }

    public Long countByPrice(Long cafeSeq, Price price) {
        return cafeInfoReviewRepository.countByCafeSeqAndPrice(cafeSeq, price);
    }

    public Long countByCustomerNum(Long cafeSeq, CustomerNum customerNum) {
        return cafeInfoReviewRepository.countByCafeSeqAndCustomerNum(cafeSeq, customerNum);
    }

    public Long countByStayLong(Long cafeSeq, StayLong stayLong) {
        return cafeInfoReviewRepository.countByCafeSeqAndStayLong(cafeSeq, stayLong);
    }

    public Long countByPlugNum(Long cafeSeq, PlugNum plugNum) {
        return cafeInfoReviewRepository.countByCafeSeqAndPlugNum(cafeSeq, plugNum);
    }

    public Long countByTableHeight(Long cafeSeq, TableHeight tableHeight) {
        return cafeInfoReviewRepository.countByCafeSeqAndTableHeight(cafeSeq, tableHeight);
    }

    public Long countByLightness(Long cafeSeq, Lightness lightness) {
        return cafeInfoReviewRepository.countByCafeSeqAndLightness(cafeSeq, lightness);
    }

    public Long countReviews(Long cafeSeq) {
        return cafeInfoReviewRepository.countByCafeSeq(cafeSeq);
    }
}
