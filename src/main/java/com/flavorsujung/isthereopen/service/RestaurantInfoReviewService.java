package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.respository.RestaurantInfoReviewRepository;
import com.flavorsujung.isthereopen.respository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantInfoReviewService {
    private final RestaurantInfoReviewRepository restaurantInfoReviewRepository;
    private final RestaurantRepository restaurantRepository;

    public void putRestaurantInfoReview(RestaurantInfoReview restaurantInfoReview) {
        restaurantInfoReviewRepository.save(restaurantInfoReview);
        Restaurant restaurant = restaurantRepository.findRestaurantBySeq(restaurantInfoReview.getRestaurantSeq());
        restaurant.setAvgRate(getAvgRate(restaurantInfoReview.getRestaurantSeq()));
        Long restaurantSeq = restaurantInfoReview.getRestaurantSeq();
        List<String> list = getAvgCleanness(restaurantSeq);
        if (list.contains("깨끗한 편"))
            restaurant.setClean(1);
        else
            restaurant.setClean(0);
        if (list.size() == 0) {
            restaurant.setAvgCleanness("정보 없음");
        }
        else if(list.size() == 1) {
            restaurant.setAvgCleanness(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            restaurant.setAvgCleanness(list.get(0) + "~" + list.get(1));
        }
        else {
            restaurant.setAvgCleanness("의견이 많이 갈려요");
            restaurant.setClean(0);
        }
        list = getAvgEatAlone(restaurantSeq);
        if (list.contains("완전 가능"))
            restaurant.setEatAlone(1);
        else
            restaurant.setEatAlone(0);
        if (list.size() == 0) {
            restaurant.setAvgEatAlone("정보 없음");
        }
        else if(list.size() == 1) {
            restaurant.setAvgEatAlone(list.get(0));
        }
        else if(list.size() == 2 && list.contains("혼잡 시간 피하면 가능")) {
            restaurant.setAvgEatAlone(list.get(0) + "~" + list.get(1));
        }
        else {
            restaurant.setAvgCleanness("의견이 많이 갈려요");
            restaurant.setEatAlone(0);
        }
        list = getAvgOpenStyle(restaurantSeq);
        if (list.contains("잘 지키는 편"))
            restaurant.setStable(1);
        else
            restaurant.setStable(0);
        if (list.size() == 0) {
            restaurant.setAvgOpenStyle("정보 없음");
        }
        else if(list.size() == 1) {
            restaurant.setAvgOpenStyle(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            restaurant.setAvgOpenStyle(list.get(0) + "~" + list.get(1));
        }
        else {
            restaurant.setAvgOpenStyle("의견이 많이 갈려요");
            restaurant.setStable(0);
        }
        list = getAvgPrice(restaurantSeq);
        if (list.contains("싼 편"))
            restaurant.setCheap(1);
        else
            restaurant.setCheap(0);
        if (list.size() == 0) {
            restaurant.setAvgPrice("정보 없음");
        }
        else if(list.size() == 1) {
            restaurant.setAvgPrice(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            restaurant.setAvgPrice(list.get(0) + "~" + list.get(1));
        }
        else {
            restaurant.setAvgPrice("의견이 많이 갈려요");
            restaurant.setCheap(0);
        }
        list = getAvgTakeout(restaurantSeq);
        if (list.contains("포장 가능"))
            restaurant.setTakeout(1);
        else
            restaurant.setTakeout(0);
        if (list.size() == 0) {
            restaurant.setAvgTakeOut("정보 없음");
        }
        else if(list.size() == 1) {
            restaurant.setAvgTakeOut(list.get(0));
        }
        else {
            restaurant.setAvgTakeOut("의견이 많이 갈려요");
            restaurant.setTakeout(0);
        }
        list = getAvgWaitingTime(restaurantSeq);
        if (list.contains("금방 나오는 편"))
            restaurant.setShortWaiting(1);
        else
            restaurant.setShortWaiting(0);
        if (list.size() == 0) {
            restaurant.setAvgWaitingTime("정보 없음");
        }
        else if(list.size() == 1) {
            restaurant.setAvgWaitingTime(list.get(0));
        }
        else {
            restaurant.setAvgWaitingTime("의견이 많이 갈려요");
            restaurant.setShortWaiting(0);
        }

        restaurantRepository.save(restaurant);
    }

    public List<RestaurantInfoReview> getRestaurantInfoReviewList(Long restaurantSeq) {
        List<RestaurantInfoReview> reviewList = restaurantInfoReviewRepository.findRestaurantInfoReviewByRestaurantSeq(restaurantSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt())); //최신순으로 정렬
        }
        return reviewList;
    }

    public List<String> getAvgOpenStyle(Long restaurantSeq) {
        Long stable = restaurantInfoReviewRepository.countByRestaurantSeqAndOpenStyle(restaurantSeq, OpenStyle.STABLE);
        Long normal = restaurantInfoReviewRepository.countByRestaurantSeqAndOpenStyle(restaurantSeq, OpenStyle.NORMAL);
        Long unstable = restaurantInfoReviewRepository.countByRestaurantSeqAndOpenStyle(restaurantSeq, OpenStyle.UNSTABLE);
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

    public List<String> getAvgPrice(Long restaurantSeq) {
        Long cheap = restaurantInfoReviewRepository.countByRestaurantSeqAndPrice(restaurantSeq, Price.CHEAP);
        Long normal = restaurantInfoReviewRepository.countByRestaurantSeqAndPrice(restaurantSeq, Price.NORMAL);
        Long expensive = restaurantInfoReviewRepository.countByRestaurantSeqAndPrice(restaurantSeq, Price.EXPENSIVE);
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

    public List<String> getAvgTakeout(Long restaurantSeq) {
        Long possible = restaurantInfoReviewRepository.countByRestaurantSeqAndTakeOut(restaurantSeq, TakeOut.POSSIBLE);
        Long unable = restaurantInfoReviewRepository.countByRestaurantSeqAndTakeOut(restaurantSeq, TakeOut.UNABLE);
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

    public List<String> getAvgEatAlone(Long restaurantSeq) {
        Long possible = restaurantInfoReviewRepository.countByRestaurantSeqAndEatAlone(restaurantSeq, EatAlone.POSSIBLE);
        Long normal = restaurantInfoReviewRepository.countByRestaurantSeqAndEatAlone(restaurantSeq, EatAlone.UNCOMFORTABLE);
        Long unable = restaurantInfoReviewRepository.countByRestaurantSeqAndEatAlone(restaurantSeq, EatAlone.UNABLE);
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

    public List<String> getAvgWaitingTime(Long restaurantSeq) {
        Long longCount = restaurantInfoReviewRepository.countByRestaurantSeqAndWaitingTime(restaurantSeq, WaitingTime.LONG);
        Long normalCount = restaurantInfoReviewRepository.countByRestaurantSeqAndWaitingTime(restaurantSeq, WaitingTime.NORMAL);
        Long shortCount = restaurantInfoReviewRepository.countByRestaurantSeqAndWaitingTime(restaurantSeq, WaitingTime.SHORT);
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

    public List<String> getAvgCleanness(Long restaurantSeq) {
        Long clean = restaurantInfoReviewRepository.countByRestaurantSeqAndCleanness(restaurantSeq, Cleanness.CLEAN);
        Long normal = restaurantInfoReviewRepository.countByRestaurantSeqAndCleanness(restaurantSeq, Cleanness.NORMAL);
        Long dirty = restaurantInfoReviewRepository.countByRestaurantSeqAndCleanness(restaurantSeq, Cleanness.DIRTY);
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

    public long countReviews(Long restaurantSeq) {
        return restaurantInfoReviewRepository.countByRestaurantSeq(restaurantSeq);
    }

    public Double getAvgRate(Long restaurantSeq) {
        List<RestaurantInfoReview> restaurantInfoReviewList = restaurantInfoReviewRepository.findRestaurantInfoReviewByRestaurantSeq(restaurantSeq);
        Double sum = 0.0;
        Long count = restaurantInfoReviewRepository.countByRestaurantSeq(restaurantSeq);
        for(RestaurantInfoReview review : restaurantInfoReviewList) {
            sum += review.getRate().getRate();
        }
        if(sum == 0.0) {
            return 0.0;
        }
        return sum / count;
    }
}
