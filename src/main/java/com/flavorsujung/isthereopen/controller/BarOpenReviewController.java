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
    private final BarService barService;
//    public static Map<Integer, BarOpenReview> barOpenReviewMap;
    @PostConstruct
    public void init(){
//        barOpenReviewMap = new HashMap<>();
//        barOpenReviewMap.put(0, new BarOpenReview(1, 1, 2, CLOSE));
//        barOpenReviewMap.put(1, new BarOpenReview(2, 2, 1, UNKNOWN));
    }

    @GetMapping("/bar/{seq}/openReview")// 술집 오픈리뷰 리스트 조회(8/18 API 테스트 완료)
    public List<BarOpenReview> getBarOpenReviewList(@PathVariable("seq") Long seq) {
        return barOpenReviewService.getBarOpenReviewList(seq);
    }

    @PutMapping("/bar/{barSeq}/openReview")// 술집 오픈리뷰 작성(8/18 API 테스트 완료)
    public ResponseEntity<Void> putBarOpenReview(
            @PathVariable Long barSeq,
            @RequestParam("userSeq") Long userSeq,
            @RequestParam("openState") OpenState openState) {
        barOpenReviewService.putBarOpenReview(barSeq, userSeq, openState);
        Bar bar = barService.getBar(barSeq);
        bar.setCurrentState(openState);
        bar.setLastUpdate(new Date());
        barService.postBar(bar);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
