package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.req.ReqBarInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.BarInfoReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarInfoReviewService {
    private final BarInfoReviewRepository barInfoReviewRepository;

    public void putBarInfoReview(Integer barSeq, ReqBarInfoReviewCreate reqBarInfoReviewCreate) {
        BarInfoReview barInfoReview = new BarInfoReview();
        barInfoReview.setBarSeq(barSeq);
        barInfoReview.setUserSeq(reqBarInfoReviewCreate.getUserSeq());
        barInfoReview.setCleanness(reqBarInfoReviewCreate.getCleanness());
        barInfoReview.setMood(reqBarInfoReviewCreate.getMood());
        barInfoReview.setOpenStyle(reqBarInfoReviewCreate.getOpenStyle());
        barInfoReview.setPrice(reqBarInfoReviewCreate.getPrice());
        barInfoReview.setMainAlcohol(reqBarInfoReviewCreate.getMainAlcohol());
        int insertCount = barInfoReviewRepository.insertBarInfoReview(barInfoReview);
    }

    public List<BarInfoReview> getBarInfoReviewList(Integer barSeq) {
        return barInfoReviewRepository.findBarInfoReviewBySeq(barSeq);
    }
}
