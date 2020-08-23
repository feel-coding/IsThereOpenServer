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
    public List<String> getAvgToilet(@PathVariable("barSeq") Long barSeq) {
        Long one = barInfoReviewService.countByToilet(barSeq, Toilet.ONE);
        Long separate = barInfoReviewService.countByToilet(barSeq, Toilet.SEPARATION);
        List<String> list = new ArrayList<>();
        Long maxCount = Math.max(one, separate);
        if(maxCount != 0) {
            if (one.equals(maxCount)) {
                list.add("남녀 공용");
            }
            if (separate.equals(maxCount)) {
                list.add("남녀 분리");
            }

        }
        return list;
    }

    @GetMapping("/bar/{barSeq}/openStyle")
    public List<String> getAvgOpenStyle(@PathVariable("barSeq") Long barSeq) {
        Long stable = barInfoReviewService.countByOpenStyle(barSeq, OpenStyle.STABLE);
        Long normal = barInfoReviewService.countByOpenStyle(barSeq, OpenStyle.NORMAL);
        Long unstable = barInfoReviewService.countByOpenStyle(barSeq, OpenStyle.UNSTABLE);
        List<String> openStyleList = new ArrayList<>();
        Long maxCount = Math.max(stable, Math.max(normal, unstable));
        if(maxCount != 0) {
            if(stable.equals(maxCount)) {
                openStyleList.add("잘 지키는 편");
            }
            if (normal.equals(maxCount)) {
                openStyleList.add("보통");
            }
            if(unstable.equals(maxCount)) {
                openStyleList.add("마음대로 여는 편");
            }
        }
        return openStyleList;
    }

    @GetMapping("/bar/{barSeq}/mood")
    public List<String> getAvgMood(@PathVariable("barSeq") Long barSeq) {
        Long loudCount = barInfoReviewService.countByMood(barSeq, Mood.LOUD);
        Long normalCount = barInfoReviewService.countByMood(barSeq, Mood.NORMAL);
        Long silentCount = barInfoReviewService.countByMood(barSeq, Mood.SILENT);
        List<String> moodList = new ArrayList<>();
        Long maxCount = Math.max(loudCount, Math.max(normalCount, silentCount));
        if(maxCount != 0) {
            if (silentCount.equals(maxCount)) {
                moodList.add("조용한 편");
            }
            if (normalCount.equals(maxCount)) {
                moodList.add("보통");
            }
            if (loudCount.equals(maxCount)) {
                moodList.add("시끄러운 편");
            }
        }
        return moodList;
    }

    @GetMapping("/bar/{barSeq}/alcohol")
    public List<String> getAvgAlcohol(@PathVariable("barSeq") Long barSeq) {
        Long soju = barInfoReviewService.countByAlcohol(barSeq, Alcohol.SOJU);
        Long beer = barInfoReviewService.countByAlcohol(barSeq, Alcohol.BEER);
        Long makgeolli = barInfoReviewService.countByAlcohol(barSeq, Alcohol.MAKGEOLLI);
        Long wine = barInfoReviewService.countByAlcohol(barSeq, Alcohol.WINE);
        Long vodka = barInfoReviewService.countByAlcohol(barSeq, Alcohol.VODKA);
        List<String> list = new ArrayList<>();
        Long maxCount = Math.max(soju, Math.max(beer, Math.max(makgeolli, Math.max(wine, vodka))));
        if(maxCount != 0) {
            if(soju.equals(maxCount)) {
                list.add("소주");
            }
            if (beer.equals(maxCount)) {
                list.add("맥주");
            }
            if (makgeolli.equals(maxCount)) {
                list.add("막걸리");
            }
            if (wine.equals(maxCount)) {
                list.add("와인");
            }
            if(vodka.equals(maxCount)) {
                list.add("보드카");
            }
        }
        return list;

    }

    @GetMapping("/bar/{barSeq}/cleanness")
    public List<String> getAvgCleanness(@PathVariable("barSeq") Long barSeq) {
        Long clean = barInfoReviewService.countByCleanness(barSeq, Cleanness.CLEAN);
        Long normal = barInfoReviewService.countByCleanness(barSeq, Cleanness.NORMAL);
        Long dirty = barInfoReviewService.countByCleanness(barSeq, Cleanness.DIRTY);
        List<String> list = new ArrayList<>();
        Long maxCount = Math.max(clean, Math.max(normal, dirty));
        if(maxCount != 0) {
            if (dirty.equals(maxCount)) {
                list.add("더러운 편");
            }
            if (normal.equals(maxCount)) {
                list.add("보통");
            }
            if (clean.equals(maxCount)) {
                list.add("깨끗한 편");
            }
        }
        return list;
    }

    @GetMapping("/bar/{barSeq}/price")
    public List<String> getAvgPrice(@PathVariable("barSeq") Long barSeq) {
        Long cheap = barInfoReviewService.countByPrice(barSeq, Price.CHEAP);
        Long normal = barInfoReviewService.countByPrice(barSeq, Price.NORMAL);
        Long expensive = barInfoReviewService.countByPrice(barSeq, Price.EXPENSIVE);
        List<String> priceList = new ArrayList<>();
        Long maxCount = Math.max(cheap, Math.max(normal, expensive));
        if(maxCount != 0) {
            if(cheap.equals(maxCount)) {
                priceList.add("싼 편");
            }
            if (normal.equals(maxCount)) {
                priceList.add("보통");
            }
            if(expensive.equals(maxCount)) {
                priceList.add("비싼 편");
            }
        }
        return priceList;
    }

    @GetMapping("/bar/{barSeq}/avgRate")
    public Double getAvgRate(@PathVariable("barSeq") Long barSeq) {
        List<BarInfoReview> barInfoReviewList = barInfoReviewService.getBarInfoReviewList(barSeq);
        Double sum = 0.0;
        Long count = barInfoReviewService.countReview(barSeq);
        for(BarInfoReview review : barInfoReviewList) {
            sum += review.getRate().getRate();
        }
        if(sum == 0.0) {
            return 0.0;
        }
        return sum / count;
    }
}
