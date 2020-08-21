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
    public List<OpenStyle> getAvgOpenStyle(@PathVariable("cafeSeq") Long cafeSeq) {
        Long stable = cafeInfoReviewService.countByOpenStyle(cafeSeq, OpenStyle.STABLE);
        Long normal = cafeInfoReviewService.countByOpenStyle(cafeSeq, OpenStyle.NORMAL);
        Long unstable = cafeInfoReviewService.countByOpenStyle(cafeSeq, OpenStyle.UNSTABLE);
        List<OpenStyle> openStyleList = new ArrayList<>();
        Long maxCount = Math.max(stable, Math.max(normal, unstable));
        if(maxCount != 0) {
            if(stable.equals(maxCount)) {
                openStyleList.add(OpenStyle.STABLE);
            }
            if (normal.equals(maxCount)) {
                openStyleList.add(OpenStyle.NORMAL);
            }
            if(unstable.equals(maxCount)) {
                openStyleList.add(OpenStyle.UNSTABLE);
            }
        }
        return openStyleList;
    }

    @GetMapping("/cafe/{cafeSeq}/waitingTime")
    public List<WaitingTime> countByWaitingTime(@PathVariable("cafeSeq") Long cafeSeq) {
        Long longCount = cafeInfoReviewService.countByWaitingTime(cafeSeq, WaitingTime.LONG);
        Long normalCount = cafeInfoReviewService.countByWaitingTime(cafeSeq, WaitingTime.NORMAL);
        Long shortCount = cafeInfoReviewService.countByWaitingTime(cafeSeq, WaitingTime.SHORT);
        List<WaitingTime> waitingTimeList = new ArrayList<>();
        Long maxCount = Math.max(longCount, Math.max(normalCount, shortCount));
        if(maxCount != 0) {
            if(shortCount.equals(maxCount)) {
                waitingTimeList.add(WaitingTime.SHORT);
            }
            if (normalCount.equals(maxCount)) {
                waitingTimeList.add(WaitingTime.NORMAL);
            }
            if(longCount.equals(maxCount)) {
                waitingTimeList.add(WaitingTime.LONG);
            }
        }
        return waitingTimeList;
    }

    @GetMapping("/cafe/{cafeSeq}/price")
    public List<Price> getAvgPrice(@PathVariable("cafeSeq") Long cafeSeq) {
        Long cheap = cafeInfoReviewService.countByPrice(cafeSeq, Price.CHEAP);
        Long normal = cafeInfoReviewService.countByPrice(cafeSeq, Price.NORMAL);
        Long expensive = cafeInfoReviewService.countByPrice(cafeSeq, Price.EXPENSIVE);
        List<Price> priceList = new ArrayList<>();
        Long maxCount = Math.max(cheap, Math.max(normal, expensive));
        if(maxCount != 0) {
            if(cheap.equals(maxCount)) {
                priceList.add(Price.CHEAP);
            }
            if (normal.equals(maxCount)) {
                priceList.add(Price.NORMAL);
            }
            if(expensive.equals(maxCount)) {
                priceList.add(Price.EXPENSIVE);
            }
        }
        return priceList;
    }

    @GetMapping("/cafe/{cafeSeq}/customerNum")
    public List<CustomerNum> getAvgCustomerNum(@PathVariable("cafeSeq") Long cafeSeq) {
        Long many = cafeInfoReviewService.countByCustomerNum(cafeSeq, CustomerNum.CROWDED);
        Long normal = cafeInfoReviewService.countByCustomerNum(cafeSeq, CustomerNum.NORMAL);
        Long little = cafeInfoReviewService.countByCustomerNum(cafeSeq, CustomerNum.UNCROWDED);
        List<CustomerNum> customerNumList = new ArrayList<>();
        Long maxCount = Math.max(little, Math.max(normal, many));
        if(maxCount != 0) {
            if(little.equals(maxCount)) {
                customerNumList.add(CustomerNum.UNCROWDED);
            }
            if (normal.equals(maxCount)) {
                customerNumList.add(CustomerNum.NORMAL);
            }
            if(many.equals(maxCount)) {
                customerNumList.add(CustomerNum.CROWDED);
            }
        }
        return customerNumList;
    }

    @GetMapping("/cafe/{cafeSeq}/stayLong")
    public List<StayLong> countByStayLong(@PathVariable("cafeSeq") Long cafeSeq) {
        Long possible = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.POSSIBLE);
        Long normal = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.NORMAL);
        Long unable = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.UNCOMFORTABLE);
        Long takeout = cafeInfoReviewService.countByStayLong(cafeSeq, StayLong.TAKEOUT);
        List<StayLong> stayLongList = new ArrayList<>();
        Long maxCount = Math.max(possible, Math.max(normal, Math.max(unable, takeout)));
        if(maxCount != 0) {
            if(unable.equals(maxCount)) {
                stayLongList.add(StayLong.POSSIBLE);
            }
            if (normal.equals(maxCount)) {
                stayLongList.add(StayLong.NORMAL);
            }
            if(possible.equals(maxCount)) {
                stayLongList.add(StayLong.UNCOMFORTABLE);
            }
            if (takeout.equals(maxCount)) {
                stayLongList.add(StayLong.TAKEOUT);
            }
        }
        return stayLongList;
    }

    @GetMapping("/cafe/{cafeSeq}/plugNum")
    public List<PlugNum> getAvgPlugNum(@PathVariable("cafeSeq") Long cafeSeq) {
        Long many = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.MANY);
        Long normal = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.NORMAL);
        Long little = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.LITTLE);
        Long no = cafeInfoReviewService.countByPlugNum(cafeSeq, PlugNum.NOTABLE);
        List<PlugNum> plugNumList = new ArrayList<>();
        Long maxCount = Math.max(many, Math.max(normal, Math.max(normal, little)));
        if(maxCount != 0) {
            if(little.equals(maxCount)) {
                plugNumList.add(PlugNum.LITTLE);
            }
            if (normal.equals(maxCount)) {
                plugNumList.add(PlugNum.NORMAL);
            }
            if(many.equals(maxCount)) {
                plugNumList.add(PlugNum.MANY);
            }
            if (no.equals(maxCount)) {
                plugNumList.add(PlugNum.NOTABLE);
            }
        }
        return plugNumList;
    }

    @GetMapping("/cafe/{cafeSeq}/tableHeight")
    public List<TableHeight> getAvgTableHeight(@PathVariable("cafeSeq") Long cafeSeq) {
        Long highCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.HIGH);
        Long normalCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.NORMAL);
        Long lowCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.LOW);
        Long noCount = cafeInfoReviewService.countByTableHeight(cafeSeq, TableHeight.NOTABLE);
        List<TableHeight> tableHeightList = new ArrayList<>();
        Long maxCount = Math.max(highCount, Math.max(normalCount,Math.max(lowCount, noCount)));
        if(maxCount != 0) {
            if (maxCount.equals(highCount)) {
                tableHeightList.add(TableHeight.HIGH);
            }
            if (maxCount.equals(normalCount)) {
                tableHeightList.add(TableHeight.NORMAL);
            }
            if (maxCount.equals(lowCount)) {
                tableHeightList.add(TableHeight.LOW);
            }
            if (maxCount.equals(noCount)) {
                tableHeightList.add(TableHeight.NOTABLE);
            }
        }
        return tableHeightList;
    }

    @GetMapping("/cafe/{cafeSeq}/lightness")
    public List<Lightness> getAvgLightness(@PathVariable("cafeSeq") Long cafeSeq) {
        Long lightCount = cafeInfoReviewService.countByLightness(cafeSeq, Lightness.LIGHT);
        Long normalCount = cafeInfoReviewService.countByLightness(cafeSeq, Lightness.NORMAL);
        Long darkCount = cafeInfoReviewService.countByLightness(cafeSeq, Lightness.DARK);
        List<Lightness> lightnessList = new ArrayList<>();
        Long maxCount = Math.max(Math.max(lightCount, normalCount), darkCount);
        if(maxCount != 0) {
            if (lightCount.equals(maxCount))
                lightnessList.add(Lightness.LIGHT);
            if (normalCount.equals(maxCount))
                lightnessList.add(Lightness.NORMAL);
            if (darkCount.equals(maxCount))
                lightnessList.add(Lightness.DARK);
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
        return sum / count;
    }

}
