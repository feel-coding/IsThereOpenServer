package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.domain.req.ReqBarInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.BarInfoReviewRepository;
import com.flavorsujung.isthereopen.respository.BarRepository;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BarInfoReviewService {
    private final BarInfoReviewRepository barInfoReviewRepository;
    private final BarRepository barRepository;

    public void putBarInfoReview(BarInfoReview barInfoReview) {
        barInfoReviewRepository.save(barInfoReview);
        Bar bar = barRepository.findBarBySeq(barInfoReview.getBarSeq());
        bar.setAvgRate(getAvgRate(barInfoReview.getBarSeq()));
        Long barSeq = barInfoReview.getBarSeq();
        List<String> list = getAvgCleanness(barSeq);
        if (list.contains("깨끗한 편"))
            bar.setClean(1);
        else
            bar.setClean(0);
        if (list.size() == 0) {
            bar.setAvgCleanness("정보 없음");
        }
        else if(list.size() == 1) {
            bar.setAvgCleanness(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            bar.setAvgCleanness(list.get(0) + "~" + list.get(1));
        }
        else {
            bar.setAvgCleanness("의견이 많이 갈려요");
            bar.setClean(0);
        }
        list = getAvgOpenStyle(barSeq);
        if (list.contains("잘 지키는 편"))
            bar.setStable(1);
        else
            bar.setStable(0);
        if (list.size() == 0) {
            bar.setAvgOpenStyle("정보 없음");
        }
        else if(list.size() == 1) {
            bar.setAvgOpenStyle(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            bar.setAvgOpenStyle(list.get(0) + "~" + list.get(1));
        }
        else {
            bar.setAvgOpenStyle("의견이 많이 갈려요");
            bar.setStable(0);
        }
        list = getAvgPrice(barSeq);
        if (list.contains("싼 편"))
            bar.setCheap(1);
        else
            bar.setCheap(0);
        if (list.size() == 0) {
            bar.setAvgPrice("정보 없음");
        }
        else if(list.size() == 1) {
            bar.setAvgPrice(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            bar.setAvgPrice(list.get(0) + "~" + list.get(1));
        }
        else {
            bar.setAvgPrice("의견이 많이 갈려요");
            bar.setCheap(0);
        }
        list = getAvgAlcohol(barSeq);
        if (list.contains("소주"))
            bar.setSoju(1);
        else
            bar.setSoju(0);
        if (list.contains("맥주"))
            bar.setBeer(1);
        else
            bar.setBeer(0);
        if (list.contains("막걸리"))
            bar.setMakgeolli(1);
        else
            bar.setMakgeolli(0);
        if (list.contains("와인"))
            bar.setWine(1);
        else
            bar.setWine(0);
        if (list.contains("보드카"))
            bar.setVodka(1);
        else
            bar.setVodka(0);
        if (list.size() == 0) {
            bar.setAvgMainAlcohol("정보 없음");
        }
        else if(list.size() == 1) {
            bar.setAvgMainAlcohol(list.get(0));
        }
        else if(list.size() == 2) {
            bar.setAvgMainAlcohol(list.get(0) + ", " + list.get(1));
        }
        else if(list.size() == 3) {
            bar.setAvgMainAlcohol(list.get(0) + ", " + list.get(1)+ ", " + list.get(2));
        }
        else if(list.size() == 4) {
            bar.setAvgMainAlcohol(list.get(0) + ", " + list.get(1)+ ", " + list.get(2)+ ", " + list.get(3));
        }
        else if(list.size() == 5) {
            bar.setAvgMainAlcohol(list.get(0) + ", " + list.get(1)+ ", " + list.get(2)+ ", " + list.get(3)+ ", " + list.get(4));
        }
        list = getAvgMood(barSeq);
        if (list.contains("조용한 편") || list.contains("보통"))
            bar.setNotLoud(1);
        else
            bar.setNotLoud(0);
        if (list.size() == 0) {
            bar.setAvgMood("정보 없음");
        }
        else if(list.size() == 1) {
            bar.setAvgMood(list.get(0));
        }
        else if(list.size() == 2 && list.contains("보통")) {
            bar.setAvgMood(list.get(0) + "~" + list.get(1));
        }
        else {
            bar.setAvgMood("의견이 많이 갈려요");
            bar.setNotLoud(0);
        }
        list = getAvgToilet(barSeq);
        if (list.contains("남녀 분리"))
            bar.setSeparate(1);
        else
            bar.setSeparate(0);
        if (list.size() == 0) {
            bar.setAvgToilet("정보 없음");
        }
        else if(list.size() == 1) {
            bar.setAvgToilet(list.get(0));
        }
        else if(list.size() == 2) {
            bar.setAvgToilet(list.get(0) + "," + list.get(1) + " 모두 있어요");
        }
        barRepository.save(bar);
    }

    public List<BarInfoReview> getBarInfoReviewList(Long barSeq) {
        List<BarInfoReview> reviewList = barInfoReviewRepository.findBarInfoReviewsByBarSeq(barSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }

    public List<String> getAvgToilet(Long barSeq) {
        Long one = barInfoReviewRepository.countByBarSeqAndToilet(barSeq, Toilet.ONE);
        Long separate = barInfoReviewRepository.countByBarSeqAndToilet(barSeq, Toilet.SEPARATION);
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

    public List<String> getAvgOpenStyle(Long barSeq) {
        Long stable = barInfoReviewRepository.countByBarSeqAndOpenStyle(barSeq, OpenStyle.STABLE);
        Long normal = barInfoReviewRepository.countByBarSeqAndOpenStyle(barSeq, OpenStyle.NORMAL);
        Long unstable = barInfoReviewRepository.countByBarSeqAndOpenStyle(barSeq, OpenStyle.UNSTABLE);
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

    public List<String> getAvgAlcohol(Long barSeq) {
        Long soju = barInfoReviewRepository.countByBarSeqAndMainAlcohol(barSeq, Alcohol.SOJU);
        Long beer = barInfoReviewRepository.countByBarSeqAndMainAlcohol(barSeq, Alcohol.BEER);
        Long makgeolli = barInfoReviewRepository.countByBarSeqAndMainAlcohol(barSeq, Alcohol.MAKGEOLLI);
        Long wine = barInfoReviewRepository.countByBarSeqAndMainAlcohol(barSeq, Alcohol.WINE);
        Long vodka = barInfoReviewRepository.countByBarSeqAndMainAlcohol(barSeq, Alcohol.VODKA);
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

    public List<String> getAvgMood(Long barSeq) {
        Long loudCount = barInfoReviewRepository.countByBarSeqAndMood(barSeq, Mood.LOUD);
        Long normalCount = barInfoReviewRepository.countByBarSeqAndMood(barSeq, Mood.NORMAL);
        Long silentCount = barInfoReviewRepository.countByBarSeqAndMood(barSeq, Mood.SILENT);
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
                moodList.add("회식 분위기");
            }
        }
        return moodList;
    }

    public List<String> getAvgPrice(Long barSeq) {
        Long cheap = barInfoReviewRepository.countByBarSeqAndPrice(barSeq, Price.CHEAP);
        Long normal = barInfoReviewRepository.countByBarSeqAndPrice(barSeq, Price.NORMAL);
        Long expensive = barInfoReviewRepository.countByBarSeqAndPrice(barSeq, Price.EXPENSIVE);
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

    public List<String> getAvgCleanness(Long barSeq) {
        Long clean = barInfoReviewRepository.countByBarSeqAndCleanness(barSeq, Cleanness.CLEAN);
        Long normal = barInfoReviewRepository.countByBarSeqAndCleanness(barSeq, Cleanness.NORMAL);
        Long dirty = barInfoReviewRepository.countByBarSeqAndCleanness(barSeq, Cleanness.DIRTY);
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

    public Long countReview(Long barSeq) {
        return barInfoReviewRepository.countByBarSeq(barSeq);
    }

    public Double getAvgRate(Long barSeq) {
        List<BarInfoReview> barInfoReviewList = barInfoReviewRepository.findBarInfoReviewsByBarSeq(barSeq);
        Double sum = 0.0;
        Long count = countReview(barSeq);
        for(BarInfoReview review : barInfoReviewList) {
            sum += review.getRate().getRate();
        }
        if(sum == 0.0) {
            return 0.0;
        }
        return sum / count;
    }
}