package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.service.BarInfoReviewService;
import com.flavorsujung.isthereopen.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Float.NaN;

@RestController
@RequiredArgsConstructor
public class BarInfoReviewController {
    private final BarInfoReviewService barInfoReviewService;

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
        return barInfoReviewService.getBarInfoReviewList(barSeq);
    }

    @GetMapping("/bar/{barSeq}/toilet")
    public List<String> getAvgToilet(@PathVariable("barSeq") Long barSeq) {
        return barInfoReviewService.getAvgToilet(barSeq);
    }

    @GetMapping("/bar/{barSeq}/openStyle")
    public List<String> getAvgOpenStyle(@PathVariable("barSeq") Long barSeq) {
        return barInfoReviewService.getAvgOpenStyle(barSeq);
    }

    @GetMapping("/bar/{barSeq}/mood")
    public List<String> getAvgMood(@PathVariable("barSeq") Long barSeq) {
        return barInfoReviewService.getAvgMood(barSeq);
    }

    @GetMapping("/bar/{barSeq}/alcohol")
    public List<String> getAvgAlcohol(@PathVariable("barSeq") Long barSeq) {
        return barInfoReviewService.getAvgAlcohol(barSeq);

    }

    @GetMapping("/bar/{barSeq}/cleanness")
    public List<String> getAvgCleanness(@PathVariable("barSeq") Long barSeq) {
        return barInfoReviewService.getAvgCleanness(barSeq);
    }

    @GetMapping("/bar/{barSeq}/price")
    public List<String> getAvgPrice(@PathVariable("barSeq") Long barSeq) {
        return barInfoReviewService.getAvgPrice(barSeq);
    }

    @GetMapping("/bar/{barSeq}/avgRate")
    public Double getAvgRate(@PathVariable("barSeq") Long barSeq) {
        return barInfoReviewService.getAvgRate(barSeq);
    }
}
