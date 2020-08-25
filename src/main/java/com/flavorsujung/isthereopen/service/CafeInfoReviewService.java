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
