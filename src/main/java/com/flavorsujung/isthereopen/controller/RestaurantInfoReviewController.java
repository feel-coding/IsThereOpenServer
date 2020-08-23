package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.service.RestaurantInfoReviewService;
import com.flavorsujung.isthereopen.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.Convert;
import java.util.*;

import static com.flavorsujung.isthereopen.controller.RestaurantController.restaurantMap;

@RestController
@RequiredArgsConstructor
public class RestaurantInfoReviewController {
    private final RestaurantInfoReviewService restaurantInfoReviewService;
    private final RestaurantService restaurantService;

    @PostConstruct
    public void init() {
//        restaurantInfoReviewMap = new HashMap<>();
    }

    @PutMapping("/restaurant/{restaurantSeq}/infoReview") // 식당 정보 리뷰 작성 (8/18 API 테스트 완료)
    public ResponseEntity<Void> putRestaurantInfoReviewList(
            @PathVariable("restaurantSeq") Long restaurantSeq,
            @RequestParam("userSeq") Long userSeq,
            @RequestParam("rate") Rate rate,
            @RequestParam("waitingTime") WaitingTime waitingTime,
            @RequestParam("cleanness") Cleanness cleanness,
            @RequestParam("price") Price price,
            @RequestParam("takeOut") TakeOut takeOut,
            @RequestParam("eatAlone") EatAlone eatAlone,
            @RequestParam("openStyle") OpenStyle openStyle) {
        restaurantInfoReviewService.putRestaurantInfoReview(restaurantSeq,userSeq, rate, waitingTime, cleanness, price, takeOut, eatAlone, openStyle);
        Restaurant restaurant = restaurantService.getRestaurant(restaurantSeq);
        restaurant.setAvgRate(getAvgRate(restaurantSeq));
        restaurantService.postRestaurant(restaurant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantSeq}/infoReview") // 식당 정보 리뷰 리스트 조회 (8/18 API 테스트 완료)
    public List<RestaurantInfoReview> getRestaurantInfoReviewList(@PathVariable("restaurantSeq") Long restaurantSeq) {
        List<RestaurantInfoReview> reviewList =  restaurantInfoReviewService.getRestaurantInfoReviewList(restaurantSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt())); //최신순으로 정렬
        }
        return reviewList;
    }


    @GetMapping("/restaurant/{restaurantSeq}/cleanness")
    public List<String> getAvgCleanness(@PathVariable("restaurantSeq") Long restaurantSeq) {
        Long clean = restaurantInfoReviewService.countByCleanness(restaurantSeq, Cleanness.CLEAN);
        Long normal = restaurantInfoReviewService.countByCleanness(restaurantSeq, Cleanness.NORMAL);
        Long dirty = restaurantInfoReviewService.countByCleanness(restaurantSeq, Cleanness.DIRTY);
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

    @GetMapping("/restaurant/{restaurantSeq}/price")
    public List<String> getAvgPrice(@PathVariable("restaurantSeq") Long restaurantSeq) {
        Long cheap = restaurantInfoReviewService.countByPrice(restaurantSeq, Price.CHEAP);
        Long normal = restaurantInfoReviewService.countByPrice(restaurantSeq, Price.NORMAL);
        Long expensive = restaurantInfoReviewService.countByPrice(restaurantSeq, Price.EXPENSIVE);
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

    @GetMapping("/restaurant/{restaurantSeq}/openStyle")
    public List<String> getAvgOpenStyle(@PathVariable("restaurantSeq") Long restaurantSeq) {
        Long stable = restaurantInfoReviewService.countByOpenStyle(restaurantSeq, OpenStyle.STABLE);
        Long normal = restaurantInfoReviewService.countByOpenStyle(restaurantSeq, OpenStyle.NORMAL);
        Long unstable = restaurantInfoReviewService.countByOpenStyle(restaurantSeq, OpenStyle.UNSTABLE);
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


    @GetMapping("/restaurant/{restaurantSeq}/takeout")
    public List<String> getAvgTakeOut(@PathVariable("restaurantSeq") Long restaurantSeq) {
        Long possible = restaurantInfoReviewService.countByTakeout(restaurantSeq, TakeOut.POSSIBLE);
        Long unable = restaurantInfoReviewService.countByTakeout(restaurantSeq, TakeOut.UNABLE);
        List<String> list = new ArrayList<>();
        Long maxCount = Math.max(possible, unable);
        if(maxCount != 0) {
            if (possible.equals(maxCount)) {
                list.add("포장 가능");
            }
            if (unable.equals(maxCount)) {
                list.add("포장 불가능");
            }
        }
        return list;
    }


    @GetMapping("/restaurant/{restaurantSeq}/waitingTime")
    public List<String> countByWaitingTime(@PathVariable("restaurantSeq") Long restaurantSeq) {
        Long longCount = restaurantInfoReviewService.countByWaitingTime(restaurantSeq, WaitingTime.LONG);
        Long normalCount = restaurantInfoReviewService.countByWaitingTime(restaurantSeq, WaitingTime.NORMAL);
        Long shortCount = restaurantInfoReviewService.countByWaitingTime(restaurantSeq, WaitingTime.SHORT);
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

    @GetMapping("/restaurant/{restaurantSeq}/eatAlone")
    public List<String> countByEatAlone(@PathVariable("restaurantSeq") Long restaurantSeq) {
        Long possible = restaurantInfoReviewService.countByEatAlone(restaurantSeq, EatAlone.POSSIBLE);
        Long normal = restaurantInfoReviewService.countByEatAlone(restaurantSeq, EatAlone.UNCOMFORTABLE);
        Long unable = restaurantInfoReviewService.countByEatAlone(restaurantSeq, EatAlone.UNABLE);
        List<String> list = new ArrayList<>();
        Long maxCount = Math.max(possible, Math.max(normal, unable));
        if(maxCount != 0) {
            if (unable.equals(maxCount)) {
                list.add("불가능");
            }
            if (normal.equals(maxCount)) {
                list.add("혼잡 시간 피하면 가능");
            }
            if (possible.equals(maxCount)) {
                list.add("완전 가능");
            }
        }
        return list;
    }

    @GetMapping("/restaurant/{restaurantSeq}/avgRate")
    public Double getAvgRate(@PathVariable("restaurantSeq") Long restaurantSeq) {
        List<RestaurantInfoReview> restaurantInfoReviewList = restaurantInfoReviewService.getRestaurantInfoReviewList(restaurantSeq);
        Double sum = 0.0;
        Long count = restaurantInfoReviewService.countReviews(restaurantSeq);
        for(RestaurantInfoReview review : restaurantInfoReviewList) {
            sum += review.getRate().getRate();
        }
        if(sum == 0.0) {
            return 0.0;
        }
        return sum / count;
    }
}
