package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.req.ReqBarInfoReviewCreate;
import com.flavorsujung.isthereopen.service.BarInfoReviewService;
import com.flavorsujung.isthereopen.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class BarInfoReviewController {
    private final BarInfoReviewService barInfoReviewService;
//    Map<Integer, BarInfoReview> barInfoReviewMap;

    @PostConstruct
    public void init() {
//        barInfoReviewMap = new HashMap<>();
    }
    @PutMapping("/bar/{barSeq}/infoReview")//서비스와 레파지토리 이용하여 수정함
    public ResponseEntity<Void> putBarInfoReview(@PathVariable("barSeq")Long barSeq, @RequestBody ReqBarInfoReviewCreate reqBarInfoReviewCreate) {
//        int seq = barInfoReviewMap.size();
//        BarInfoReview barInfoReview = new BarInfoReview(seq, barSeq, openStyle, cleanness, mood, mainAlcohol, price);
//        barInfoReviewMap.put(seq,barInfoReview);
//        barMap.get(barSeq).getBarInfoReviewList().add(barInfoReview);
        barInfoReviewService.putBarInfoReview(barSeq, reqBarInfoReviewCreate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/bar/{barSeq}/infoReview")//서비스와 레파지토리 이용하여 수정함
    public List<BarInfoReview> getRestaurantInfoReviewList(@PathVariable("barSeq") Long barSeq) {
//        return barMap.get(barSeq).getBarInfoReviewList();
        return barInfoReviewService.getBarInfoReviewList(barSeq);
    }

//    @GetMapping("/bar/{barSeq}/infoReview/{infoReviewSeq}")
//    public BarInfoReview getBarInfoReview(@PathVariable("barSeq") Integer barSeq, @PathVariable("infoReviewSeq") Integer infoReviewSeq) {
//        return barMap.get(barSeq).getBarInfoReviewList().get(infoReviewSeq);
//    }
}
