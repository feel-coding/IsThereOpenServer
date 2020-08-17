package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.service.CafeInfoReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CafeInfoReviewController {
    private final CafeInfoReviewService cafeInfoReviewService;

    @PostConstruct
    public void init() {
    }

    @PutMapping("/cafe/{cafeSeq}/infoReview") // 카페 정보 리뷰 작성 (8/18 API 테스트 완료)
    public ResponseEntity<Void> putCafeInfoReview(
            @PathVariable("cafeSeq") Long cafeSeq,
            @RequestParam("userSeq") Long userSeq,
            @RequestParam("openStyle") OpenStyle openStyle,
            @RequestParam("waitingTime") WaitingTime waitingTime,
            @RequestParam("price") Price price,
            @RequestParam("customerNum") CustomerNum customerNum,
            @RequestParam("plugNum") PlugNum plugNum,
            @RequestParam("rate") Rate rate,
            @RequestParam("tableHeight") TableHeight tableHeight,
            @RequestParam("lightness") Lightness lightness,
            @RequestParam("stayLong") StayLong stayLong) {
        cafeInfoReviewService.putCafeInfoReview(cafeSeq, userSeq, openStyle, waitingTime, price, customerNum, plugNum, rate, tableHeight, lightness, stayLong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cafe/{cafeSeq}/infoReview") //카페 정보 리뷰 리스트 조회 (8/18 API 테스트 완료)
    public List<CafeInfoReview> getCafeInfoReviewList(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getCafeInfoReviewList(cafeSeq);
    }


//    @GetMapping("/cafe/{cafeSeq}/infoReview/{infoReviewSeq}")
//    public CafeInfoReview getCafeInfoReview(@PathVariable("cafeSeq") Integer cafeSeq, @PathVariable("infoReviewSeq") Integer infoReviewSeq) {
//        return cafeMap.get(cafeSeq).getCafeInfoReviewList().get(infoReviewSeq);
//    }
}
