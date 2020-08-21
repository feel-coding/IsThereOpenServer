package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeInfoReviewRespository extends JpaRepository<CafeInfoReview,Long> {
    List<CafeInfoReview> findCafeInfoReviewByCafeSeq(Long cafeSeq);

    Long countByCafeSeqAndOpenStyle(Long cafeSeq, OpenStyle openStyle);

    Long countByCafeSeqAndCustomerNum(Long cafeSeq, CustomerNum customerNum);

    Long countByCafeSeqAndLightness(Long cafeSeq, Lightness lightness);

    Long countByCafeSeqAndPlugNum(Long cafeSeq, PlugNum plugNum);

    Long countByCafeSeqAndPrice(Long cafeSeq, Price price);

    Long countByCafeSeqAndStayLong(Long cafeSeq, StayLong stayLong);

    Long countByCafeSeqAndTableHeight(Long cafeSeq, TableHeight tableHeight);

    Long countByCafeSeqAndWaitingTime(Long cafeSeq, WaitingTime waitingTime);

    Long countByCafeSeq(Long cafeSeq);
}
