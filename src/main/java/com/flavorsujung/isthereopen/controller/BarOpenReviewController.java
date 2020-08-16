package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.BarOpenReview;
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

    @GetMapping("/bar/{seq}/openReview")//서비스와 레파지토리 이용하여 수정함
    public List<BarOpenReview> getBarOpenReviewList(@PathVariable Long seq) {
        return barOpenReviewService.getBarOpenReviewList(seq);
    }

    @PutMapping("/bar/{barSeq}/openReview")//서비스와 레파지토리 이용하여 수정함
    public ResponseEntity<Void> putBarOpenReview(@PathVariable Long barSeq, @RequestBody ReqBarOpenReviewCreate reqBarOpenReviewCreate) {
//        int seq = barMap.size();
//        BarOpenReview openReview = new BarOpenReview(seq, barSeq, userSeq, openState);
//        barOpenReviewMap.put(seq, openReview);
//        barMap.get(barSeq).getBarOpenReviewList().add(openReview);
//        barMap.get(barSeq).setCurrentState(openState);
//        barMap.get(barSeq).setLastUpdate(new Date());
        barOpenReviewService.putBarOpenReview(barSeq, reqBarOpenReviewCreate);
        barService.getBar(barSeq).setCurrentState(reqBarOpenReviewCreate.getOpenState());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
