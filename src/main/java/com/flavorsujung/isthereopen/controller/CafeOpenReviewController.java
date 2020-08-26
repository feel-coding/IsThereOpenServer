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
//    public static Map<Integer, CafeOpenReview> cafeOpenReviewMap;

    @PostConstruct
    public void init(){
//        cafeOpenReviewMap = new HashMap<>();
//        cafeOpenReviewMap.put(1, new CafeOpenReview(1, 1, 2, CLOSE));
//        cafeOpenReviewMap.put(2, new CafeOpenReview(2, 2, 1, UNKNOWN));
    }

    @GetMapping("/cafe/{cafeSeq}/openReview") //카페 오픈 리뷰 조회 (8/17 API 테스트 완료)
    public List<CafeOpenReview> getCafeOpenReviewList(@PathVariable("cafeSeq") Long cafeSeq) {
        List<CafeOpenReview> reviewList = cafeOpenReviewService.getCafeOpenReviewList(cafeSeq);
        if(reviewList != null) {
            Collections.sort(reviewList, (r1, r2) -> r2.getCreatedAt().compareTo(r1.getCreatedAt()));
        }
        return reviewList;
    }

    @PutMapping("/cafe/openReview") //카페 오픈 리뷰 작성
    public ResponseEntity<Void> putCafeOpenReview(@RequestBody CafeOpenReview cafeOpenReview) {
        cafeOpenReviewService.putCafeOpenReview(cafeOpenReview);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
