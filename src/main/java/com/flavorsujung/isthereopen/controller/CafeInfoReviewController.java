package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
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

    @PutMapping("/cafe/infoReview") // 카페 정보 리뷰 작성 (8/18 API 테스트 완료)
    public ResponseEntity<Void> createCafeInfoReview(@RequestBody CafeInfoReview cafeInfoReview) {
        cafeInfoReviewService.putCafeInfoReview(cafeInfoReview);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cafe/{cafeSeq}/infoReview") //카페 정보 리뷰 리스트 조회
    public List<CafeInfoReview> getCafeInfoReviewList(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getCafeInfoReviewList(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/openStyle")
    public List<String> getAvgOpenStyle(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgOpenStyle(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/waitingTime")
    public List<String> getAvgWaitingTime(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgWaitingTime(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/price")
    public List<String> getAvgPrice(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgPrice(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/customerNum")
    public List<String> getAvgCustomerNum(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgCustomerNum(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/stayLong")
    public List<String> getAvgStayLong(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgStayLong(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/plugNum")
    public List<String> getAvgPlugNum(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgPlugNum(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/tableHeight")
    public List<String> getAvgTableHeight(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgTableHeight(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/lightness")
    public List<String> getAvgLightness(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgLightness(cafeSeq);
    }

    @GetMapping("/cafe/{cafeSeq}/avgRate")
    public Double getAvgRate(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeInfoReviewService.getAvgRate(cafeSeq);
    }

}
