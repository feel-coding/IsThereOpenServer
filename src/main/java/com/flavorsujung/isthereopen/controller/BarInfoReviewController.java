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
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BarInfoReviewController {
    private final BarInfoReviewService barInfoReviewService;
    private final BarService barService;

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
        Bar bar = barService.getBar(barSeq);
        bar.setAvgRate(getAvgRate(barSeq));
        barService.postBar(bar);
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

    @GetMapping("/bar/{barSeq}/toilet")
    public Long countByToilet(@PathVariable("barSeq") Long barSeq, @RequestParam("toilet") Toilet toilet) {
        return barInfoReviewService.countByToilet(barSeq, toilet);
    }

    @GetMapping("/bar/{barSeq}/openStyle")
    public Long countByToilet(@PathVariable("barSeq") Long barSeq, @RequestParam("openStyle") OpenStyle openStyle) {
        return barInfoReviewService.countByOpenStyle(barSeq, openStyle);
    }

    @GetMapping("/bar/{barSeq}/mood")
    public Long countByMood(@PathVariable("barSeq") Long barSeq, @RequestParam("mood")  Mood mood) {
        return barInfoReviewService.countByMood(barSeq, mood);
    }

    @GetMapping("/bar/{barSeq}/alcohol")
    public Long countByAlcohol(@PathVariable("barSeq") Long barSeq, @RequestParam("alcohol") Alcohol alcohol) {
        return barInfoReviewService.countByAlcohol(barSeq, alcohol);
    }

    @GetMapping("/bar/{barSeq}/cleanness")
    public Long countByToilet(@PathVariable("barSeq") Long barSeq, @RequestParam("cleanness") Cleanness cleanness) {
        return barInfoReviewService.countByCleanness(barSeq, cleanness);
    }

    @GetMapping("/bar/{barSeq}/price")
    public Long countByToilet(@PathVariable("barSeq") Long barSeq, @RequestParam("price") Price price) {
        return barInfoReviewService.countByPrice(barSeq, price);
    }

    @GetMapping("/bar/{barSeq}/avgRate")
    public Double getAvgRate(@PathVariable("barSeq") Long barSeq) {
        List<BarInfoReview> barInfoReviewList = barInfoReviewService.getBarInfoReviewList(barSeq);
        Double sum = 0.0;
        Long count = barInfoReviewService.countReview(barSeq);
        for(BarInfoReview review : barInfoReviewList) {
            sum += review.getRate().getRate();
        }
        return sum / count;
    }
}
