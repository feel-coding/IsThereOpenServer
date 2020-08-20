package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.domain.req.ReqBarInfoReviewCreate;
import com.flavorsujung.isthereopen.service.BarInfoReviewService;
import com.flavorsujung.isthereopen.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequiredArgsConstructor
public class BarInfoReviewController {
    private final BarInfoReviewService barInfoReviewService;
//    Map<Integer, BarInfoReview> barInfoReviewMap;

    @PostConstruct
    public void init() {
    }

    @PutMapping("/bar/{barSeq}/infoReview")// 술집 정보 리뷰 추가 (8/18 API 테스트 완료)
    public ResponseEntity<Void> putBarInfoReview(
            @PathVariable("barSeq") Long barSeq,
            @RequestParam("userSeq") Long userSeq,
            @RequestParam("rate") Rate rate,
            @RequestParam("toilet") Toilet toilet,
            @RequestParam("mood") Mood mood,
            @RequestParam("mainAlcohol") Alcohol mainAlcohol,
            @RequestParam("price") Price price,
            @RequestParam("cleanness") Cleanness cleanness,
            @RequestParam("openStyle") OpenStyle openStyle) {
        barInfoReviewService.putBarInfoReview(barSeq, userSeq, rate, toilet, mood, mainAlcohol, price, cleanness, openStyle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/bar/{barSeq}/infoReview")// 술집 리뷰 리스트 조회 (8/18 API 테스트 완료)
    public List<BarInfoReview> getRestaurantInfoReviewList(@PathVariable("barSeq") Long barSeq) {
        List<BarInfoReview> reviewList = barInfoReviewService.getBarInfoReviewList(barSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }

//    @GetMapping("/bar/{barSeq}/infoReview/{infoReviewSeq}")
//    public BarInfoReview getBarInfoReview(@PathVariable("barSeq") Integer barSeq, @PathVariable("infoReviewSeq") Integer infoReviewSeq) {
//        return barMap.get(barSeq).getBarInfoReviewList().get(infoReviewSeq);
//    }
}
