package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.service.CafeInfoReviewService;
import com.flavorsujung.isthereopen.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CafeInfoReviewController {
    private final CafeInfoReviewService cafeInfoReviewService;
    private final CafeService cafeService;

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
        Cafe cafe = cafeService.getCafe(cafeSeq);
        cafe.setAvgRate(getAvgRate(cafeSeq));
        cafeService.postCafe(cafe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cafe/{cafeSeq}/infoReview") //카페 정보 리뷰 리스트 조회 (8/18 API 테스트 완료)
    public List<CafeInfoReview> getCafeInfoReviewList(@PathVariable("cafeSeq") Long cafeSeq) {
        List<CafeInfoReview> reviewList = cafeInfoReviewService.getCafeInfoReviewList(cafeSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }

    @GetMapping("/cafe/{cafeSeq}/openStyle")
    public List<String> getAvgOpenStyle(@PathVariable("cafeSeq") Long cafeSeq) {
        Long stable = cafeInfoReviewService.countByOpenStyle(cafeSeq, OpenStyle.STABLE);
        Long normal = cafeInfoReviewService.countByOpenStyle(cafeSeq, OpenStyle.NORMAL);
        Long unstable = cafeInfoReviewService.countByOpenStyle(cafeSeq, OpenStyle.UNSTABLE);
        List<String> openStyleList = new ArrayList<>();
        Long maxCount = Math.max(stable, Math.max(normal, unstable));
        if(maxCount != 0) {
            if(unstable.equals(maxCount)) {
                openStyleList.add("마음대로 여는 편");
            }
            if (normal.equals(maxCount)) {
                openStyleList.add("보통");
            }
            if(stable.equals(maxCount)) {
                openStyleList.add("잘 지키는 편");
            }
        }
        return openStyleList;
    }

    @GetMapping("/cafe/{cafeSeq}/waitingTime")
    public List<String> countByWaitingTime(@PathVariable("cafeSeq") Long cafeSeq) {
        Long longCount = cafeInfoReviewService.countByWaitingTime(cafeSeq, WaitingTime.LONG);
        Long normalCount = cafeInfoReviewService.countByWaitingTime(cafeSeq, WaitingTime.NORMAL);
        Long shortCount = cafeInfoReviewService.countByWaitingTime(cafeSeq, WaitingTime.SHORT);
        List<String> waitingTimeList = new ArrayList<>();
        Long maxCount = Math.max(longCount, Math.max(normalCount, shortCount));
        if(maxCount != 0) {
            if(shortCount.equals(maxCount)) {
                waitingTimeList.add("금방 나오는 편");
            }
            if (normalCount.equals(maxCount)) {
                waitingTimeList.add("보통");
            }
            if(longCount.equals(maxCount)) {
                waitingTimeList.add("오래 걸리는 편");
            }
        }
        return waitingTimeList;
    }

    @GetMapping("/cafe/{cafeSeq}/price")
    public List<String> getAvgPrice(@PathVariable("cafeSeq") Long cafeSeq) {
        Long cheap = cafeInfoReviewService.countByPrice(cafeSeq, Price.CHEAP);
        Long normal = cafeInfoReviewService.countByPrice(cafeSeq, Price.NORMAL);
        Long expensive = cafeInfoReviewService.countByPrice(cafeSeq, Price.EXPENSIVE);
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

    @GetMapping("/cafe/{cafeSeq}/customerNum")
    public List<String> getAvgCustomerNum(@PathVariable("cafeSeq") Long cafeSeq) {
        Long many = cafeInfoReviewService.countByCustomerNum(cafeSeq, CustomerNum.CROWDED);
        Long normal = cafeInfoReviewService.countByCustomerNum(cafeSeq, CustomerNum.NORMAL);
        Long little = cafeInfoReviewService.countByCustomerNum(cafeSeq, CustomerNum.UNCROWDED);
        List<String> customerNumList = new ArrayList<>();
        Long maxCount = Math.max(little, Math.max(normal, many));
        if(maxCount != 0) {
            if(little.equals(maxCount)) {
                customerNumList.add("적은 편");
            }
            if (normal.equals(maxCount)) {
                customerNumList.add("보통");
            }
            if(many.equals(maxCount)) {
                customerNumList.add("많은 편");
            }
        }
        return customerNumList;
    }

    @GetMapping("/cafe/{cafeSeq}/stayLong")
    public List<String> countByStayLong(@PathVariable("cafeSeq") Long cafeSeq) {
        Long possible = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.POSSIBLE);
        Long normal = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.NORMAL);
        Long unable = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.UNCOMFORTABLE);
        Long takeout = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.TAKEOUT);
        List<String> stayLongList = new ArrayList<>();
        Long maxCount = Math.max(possible, Math.max(normal, Math.max(unable, takeout)));
        if(maxCount != 0) {
            if(possible.equals(maxCount)) {
                stayLongList.add("가능");
            }
            if (normal.equals(maxCount)) {
                stayLongList.add("보통");
            }
            if(unable.equals(maxCount)) {
                stayLongList.add("눈치보여요");
            }
            if (takeout.equals(maxCount)) {
                stayLongList.add("테이블 없음");
            }
        }
        return stayLongList;
    }

    @GetMapping("/cafe/{cafeSeq}/plugNum")
    public List<String> getAvgPlugNum(@PathVariable("cafeSeq") Long cafeSeq) {
        Long many = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.MANY);
        Long normal = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.NORMAL);
        Long little = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.LITTLE);
        Long no = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.NOTABLE);
        List<String> plugNumList = new ArrayList<>();
        Long maxCount = Math.max(many, Math.max(normal, Math.max(normal, little)));
        if(maxCount != 0) {
            if(little.equals(maxCount)) {
                plugNumList.add("적은 편");
            }
            if (normal.equals(maxCount)) {
                plugNumList.add("보통");
            }
            if(many.equals(maxCount)) {
                plugNumList.add("많은 편");
            }
            if (no.equals(maxCount)) {
                plugNumList.add("테이블 없음");
            }
        }
        return plugNumList;
    }

    @GetMapping("/cafe/{cafeSeq}/tableHeight")
    public List<String> getAvgTableHeight(@PathVariable("cafeSeq") Long cafeSeq) {
        Long highCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.HIGH);
        Long normalCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.NORMAL);
        Long lowCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.LOW);
        Long noCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.NOTABLE);
        List<String> tableHeightList = new ArrayList<>();
        Long maxCount = Math.max(highCount, Math.max(normalCount,Math.max(lowCount, noCount)));
        if(maxCount != 0) {
            if (maxCount.equals(lowCount)) {
                tableHeightList.add("낮은 편");
            }
            if (maxCount.equals(normalCount)) {
                tableHeightList.add("보통");
            }
            if (maxCount.equals(highCount)) {
                tableHeightList.add("높은 편");
            }
            if (maxCount.equals(noCount)) {
                tableHeightList.add("테이블 없음");
            }
        }
        return tableHeightList;
    }

    @GetMapping("/cafe/{cafeSeq}/lightness")
    public List<String> getAvgLightness(@PathVariable("cafeSeq") Long cafeSeq) {
        Long lightCount = cafeInfoReviewService.countByLightness(cafeSeq, Lightness.LIGHT);
        Long normalCount = cafeInfoReviewService.countByLightness(cafeSeq, Lightness.NORMAL);
        Long darkCount = cafeInfoReviewService.countByLightness(cafeSeq, Lightness.DARK);
        List<String> lightnessList = new ArrayList<>();
        Long maxCount = Math.max(Math.max(lightCount, normalCount), darkCount);
        if(maxCount != 0) {
            if (darkCount.equals(maxCount))
                lightnessList.add("어두운 편");
            if (normalCount.equals(maxCount))
                lightnessList.add("보통");
            if (lightCount.equals(maxCount))
                lightnessList.add("밝은 편");
        }
        return lightnessList;
    }

    @GetMapping("/cafe/{cafeSeq}/avgRate")
    public Double getAvgRate(@PathVariable("cafeSeq") Long cafeSeq) {
        List<CafeInfoReview> cafeInfoReviewList = cafeInfoReviewService.getCafeInfoReviewList(cafeSeq);
        Double sum = 0.0;
        Long count = cafeInfoReviewService.countReviews(cafeSeq);
        for(CafeInfoReview review : cafeInfoReviewList) {
            sum += review.getRate().getRate();
        }
        if(sum == 0.0) {
            return 0.0;
        }
        return sum / count;
    }

}
