package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqBarOpenReviewCreate;
import com.flavorsujung.isthereopen.service.BarOpenReviewService;
import com.flavorsujung.isthereopen.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

import static com.flavorsujung.isthereopen.controller.BarController.*;

@RestController
@RequiredArgsConstructor
public class BarOpenReviewController {
    private final BarOpenReviewService barOpenReviewService;

    @PostConstruct
    public void init(){

    }

    @GetMapping("/bar/{seq}/openReview")// 술집 오픈리뷰 리스트 조회
    public List<BarOpenReview> getBarOpenReviewList(@PathVariable("seq") Long seq) {
        return barOpenReviewService.getBarOpenReviewList(seq);
    }

    @PutMapping("/bar/openReview")// 술집 오픈리뷰 작성
    public ResponseEntity<Void> createBarOpenReview(@RequestBody BarOpenReview barOpenReview) {
        barOpenReviewService.putBarOpenReview(barOpenReview);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
