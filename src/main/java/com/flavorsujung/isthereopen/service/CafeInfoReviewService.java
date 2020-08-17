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
        return cafeInfoReviewRepository.findCafeInfoReviewBySeq(cafeSeq);
    }
}
