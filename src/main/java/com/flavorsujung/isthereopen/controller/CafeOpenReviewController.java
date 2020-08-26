package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.entity.CafeOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.req.ReqCafeOpenReviewCreate;
import com.flavorsujung.isthereopen.service.CafeOpenReviewService;
import com.flavorsujung.isthereopen.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

import static com.flavorsujung.isthereopen.controller.CafeController.*;

@RestController
@RequiredArgsConstructor
public class CafeOpenReviewController {
    private final CafeOpenReviewService cafeOpenReviewService;

    @PostConstruct
    public void init(){

    }

    @GetMapping("/cafe/{cafeSeq}/openReview") //카페 오픈 리뷰 조회
    public List<CafeOpenReview> getCafeOpenReviewList(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeOpenReviewService.getCafeOpenReviewList(cafeSeq);
    }

    @PutMapping("/cafe/openReview") //카페 오픈 리뷰 작성
    public ResponseEntity<Void> createCafeOpenReview(@RequestBody CafeOpenReview cafeOpenReview) {
        cafeOpenReviewService.putCafeOpenReview(cafeOpenReview);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
