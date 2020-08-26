package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.respository.CafeInfoReviewRespository;
import com.flavorsujung.isthereopen.respository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeInfoReviewService {
    private final CafeInfoReviewRespository cafeInfoReviewRepository;
    private final CafeRepository cafeRepository;

    public void putCafeInfoReview(CafeInfoReview cafeInfoReview) {
        cafeInfoReviewRepository.save(cafeInfoReview);
        Cafe cafe = cafeRepository.findCafeBySeq(cafeInfoReview.getCafeSeq());
        cafe.setAvgRate(getAvgRate(cafeInfoReview.getCafeSeq()));
        Long cafeSeq = cafeInfoReview.getCafeSeq();
        List<String> list = getAvgLightness(cafeSeq);
        if (list.contains("밝은 편"))
            cafe.setLight(1);
        else
            cafe.setLight(0);
        if (list.size() == 0) {
            cafe.setAvgLightness("정보 없음");
        }
        else if(list.size() == 1) {
            cafe.setAvgLightness(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            cafe.setAvgLightness(list.get(0) + "~" + list.get(1));
        }
        else {
            cafe.setAvgLightness("의견이 많이 갈려요");
            cafe.setLight(0);
        }
        list = getAvgTableHeight(cafeSeq);
        if(list.contains("높은 편") || list.contains("보통"))
            cafe.setNotLow(1);
        else
            cafe.setNotLow(0);
        if(list.size() == 0) {
            cafe.setAvgTableHeight("정보 없음");
        }
        else if (list.size() == 1) {
            cafe.setAvgTableHeight(list.get(0));
        }
        else if (list.size() == 2 && list.contains("보통")) {
            cafe.setAvgTableHeight(list.get(0) + "~" + list.get(1));
        }
        else if (list.size() == 3) {
            cafe.setAvgTableHeight("의견이 많이 갈려요");
        }
        list = getAvgPrice(cafeSeq);
        if(list.contains("싼 편"))
            cafe.setCheap(1);
        else
            cafe.setCheap(0);
        if(list.size() == 0) {
            cafe.setAvgPrice("정보 없음");
        }
        else if (list.size() == 1) {
            cafe.setAvgPrice(list.get(0));
        }
        else if (list.size() == 2 && list.contains("보통")) {
            cafe.setAvgPrice(list.get(0) + "~" + list.get(1));
        }
        else {
            cafe.setAvgPrice("의견이 많이 갈려요");
            cafe.setCheap(0);
        }
        list = getAvgPlugNum(cafeSeq);
        if(list.contains("많은 편"))
            cafe.setManyPlug(1);
        else
            cafe.setManyPlug(0);
        if(list.size() == 0) {
            cafe.setAvgPlugNum("정보 없음");
        }
        else if (list.size() == 1) {
            cafe.setAvgPlugNum(list.get(0));
        }
        else if (list.size() == 2 && list.contains("보통")) {
            cafe.setAvgPlugNum(list.get(0) + "~" + list.get(1));
        }
        else {
            cafe.setAvgPlugNum("의견이 많이 갈려요");
            cafe.setManyPlug(0);
        }
        list = getAvgCustomerNum(cafeSeq);
        if(list.contains("적은 편"))
            cafe.setLittlePeople(1);
        else
            cafe.setLittlePeople(0);
        if(list.size() == 0) {
            cafe.setAvgCustomerNum("정보 없음");
        }
        else if (list.size() == 1) {
            cafe.setAvgCustomerNum(list.get(0));
        }
        else if (list.size() == 2 && list.contains("보통")) {
            cafe.setAvgCustomerNum(list.get(0) + "~" + list.get(1));
        }
        else {
            cafe.setAvgCustomerNum("의견이 많이 갈려요");
            cafe.setLittlePeople(0);
        }
        list = getAvgOpenStyle(cafeSeq);
        if(list.contains("잘 지키는 편"))
            cafe.setStable(1);
        else
            cafe.setStable(0);
        if(list.size() == 0) {
            cafe.setAvgOpenStyle("정보 없음");
        }
        else if (list.size() == 1) {
            cafe.setAvgOpenStyle(list.get(0));
        }
        else if (list.size() == 2 && list.contains("보통")) {
            cafe.setAvgOpenStyle(list.get(0) + "~" + list.get(1));
        }
        else {
            cafe.setAvgOpenStyle("의견이 많이 갈려요");
            cafe.setStable(0);
        }
        list = getAvgStayLong(cafeSeq);
        if(list.contains("가능"))
            cafe.setStayLong(1);
        else
            cafe.setStayLong(0);
        if(list.size() == 0) {
            cafe.setAvgStayLong("정보 없음");
        }
        else if (list.size() == 1) {
            cafe.setAvgStayLong(list.get(0));
        }
        else if (list.size() == 2 && list.contains("보통")) {
            cafe.setAvgStayLong(list.get(0) + "~" + list.get(1));
        }
        else {
            cafe.setAvgStayLong("의견이 많이 갈려요");
        }
        list = getAvgWaitingTime(cafeSeq);
        if(list.contains("금방 나오는 편"))
            cafe.setShortWaiting(1);
        else
            cafe.setShortWaiting(0);
        if(list.size() == 0) {
            cafe.setAvgWaitingTime("정보 없음");
        }
        else if (list.size() == 1) {
            cafe.setAvgWaitingTime(list.get(0));
        }
        else if (list.size() == 2 && list.contains("보통")) {
            cafe.setAvgWaitingTime(list.get(0) + "~" + list.get(1));
        }
        else {
            cafe.setAvgStayLong("의견이 많이 갈려요");
        }
        cafeRepository.save(cafe);
    }

    public List<CafeInfoReview> getCafeInfoReviewList(Long cafeSeq) {
        List<CafeInfoReview> reviewList = cafeInfoReviewRepository.findCafeInfoReviewByCafeSeq(cafeSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }

    public Double getAvgRate(Long cafeSeq) {
        List<CafeInfoReview> cafeInfoReviewList = cafeInfoReviewRepository.findCafeInfoReviewByCafeSeq(cafeSeq);
        Double sum = 0.0;
        Long count = countReviews(cafeSeq);
        for(CafeInfoReview review : cafeInfoReviewList) {
            sum += review.getRate().getRate();
        }
        if(sum == 0.0) {
            return 0.0;
        }
        return sum / count;
    }

    public List<String> getAvgOpenStyle(Long cafeSeq) {
        Long stable = cafeInfoReviewRepository.countByCafeSeqAndOpenStyle(cafeSeq, OpenStyle.STABLE);
        Long normal = cafeInfoReviewRepository.countByCafeSeqAndOpenStyle(cafeSeq, OpenStyle.NORMAL);
        Long unstable = cafeInfoReviewRepository.countByCafeSeqAndOpenStyle(cafeSeq, OpenStyle.UNSTABLE);
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

    public List<String> getAvgWaitingTime(Long cafeSeq) {
        Long longCount = cafeInfoReviewRepository.countByCafeSeqAndWaitingTime(cafeSeq, WaitingTime.LONG);
        Long normalCount = cafeInfoReviewRepository.countByCafeSeqAndWaitingTime(cafeSeq, WaitingTime.NORMAL);
        Long shortCount = cafeInfoReviewRepository.countByCafeSeqAndWaitingTime(cafeSeq, WaitingTime.SHORT);
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

    public List<String> getAvgPrice(Long cafeSeq) {
        Long cheap = cafeInfoReviewRepository.countByCafeSeqAndPrice(cafeSeq, Price.CHEAP);
        Long normal = cafeInfoReviewRepository.countByCafeSeqAndPrice(cafeSeq, Price.NORMAL);
        Long expensive = cafeInfoReviewRepository.countByCafeSeqAndPrice(cafeSeq, Price.EXPENSIVE);
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

    public List<String> getAvgCustomerNum(Long cafeSeq) {
        Long many = cafeInfoReviewRepository.countByCafeSeqAndCustomerNum(cafeSeq, CustomerNum.CROWDED);
        Long normal = cafeInfoReviewRepository.countByCafeSeqAndCustomerNum(cafeSeq, CustomerNum.NORMAL);
        Long little = cafeInfoReviewRepository.countByCafeSeqAndCustomerNum(cafeSeq, CustomerNum.UNCROWDED);
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

    public List<String> getAvgStayLong(Long cafeSeq) {
        Long possible = cafeInfoReviewRepository.countByCafeSeqAndStayLong(cafeSeq, StayLong.POSSIBLE);
        Long normal = cafeInfoReviewRepository.countByCafeSeqAndStayLong(cafeSeq, StayLong.NORMAL);
        Long unable = cafeInfoReviewRepository.countByCafeSeqAndStayLong(cafeSeq, StayLong.UNCOMFORTABLE);
        Long takeout = cafeInfoReviewRepository.countByCafeSeqAndStayLong(cafeSeq, StayLong.TAKEOUT);
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

    public List<String> getAvgPlugNum(Long cafeSeq) {
        Long many = cafeInfoReviewRepository.countByCafeSeqAndPlugNum(cafeSeq, PlugNum.MANY);
        Long normal = cafeInfoReviewRepository.countByCafeSeqAndPlugNum(cafeSeq, PlugNum.NORMAL);
        Long little = cafeInfoReviewRepository.countByCafeSeqAndPlugNum(cafeSeq, PlugNum.LITTLE);
        Long no = cafeInfoReviewRepository.countByCafeSeqAndPlugNum(cafeSeq, PlugNum.NOTABLE);
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

    public List<String> getAvgTableHeight(Long cafeSeq) {
        Long highCount = cafeInfoReviewRepository.countByCafeSeqAndTableHeight(cafeSeq, TableHeight.HIGH);
        Long normalCount = cafeInfoReviewRepository.countByCafeSeqAndTableHeight(cafeSeq, TableHeight.NORMAL);
        Long lowCount = cafeInfoReviewRepository.countByCafeSeqAndTableHeight(cafeSeq, TableHeight.LOW);
        Long noCount = cafeInfoReviewRepository.countByCafeSeqAndTableHeight(cafeSeq, TableHeight.NOTABLE);
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

    public List<String> getAvgLightness(Long cafeSeq) {
        Long lightCount = cafeInfoReviewRepository.countByCafeSeqAndLightness(cafeSeq, Lightness.LIGHT);
        Long normalCount = cafeInfoReviewRepository.countByCafeSeqAndLightness(cafeSeq, Lightness.NORMAL);
        Long darkCount = cafeInfoReviewRepository.countByCafeSeqAndLightness(cafeSeq, Lightness.DARK);
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

    public Long countReviews(Long cafeSeq) {
        return cafeInfoReviewRepository.countByCafeSeq(cafeSeq);
    }
}
