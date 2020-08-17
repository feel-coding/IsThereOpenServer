package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.CafeInfoReview;
import com.flavorsujung.isthereopen.domain.req.ReqCafeInfoReviewCreate;
import com.flavorsujung.isthereopen.respository.CafeInfoReviewRespository;
import com.flavorsujung.isthereopen.service.CafeInfoReviewService;
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
public class CafeInfoReviewController {
    private final CafeInfoReviewService cafeInfoReviewService;
//    Map<Integer, CafeInfoReview> cafeInfoReviewMap;

    @PostConstruct
    public void init() {
//        cafeInfoReviewMap = new HashMap<>();
    }

    @PutMapping("/cafe/{cafeSeq}/infoReview")
    public ResponseEntity<Void> putCafeInfoReview(
            @PathVariable("cafeSeq") Long cafeSeq, @RequestBody ReqCafeInfoReviewCreate reqCafeInfoReviewCreate) {
//        int seq = cafeInfoReviewMap.size();
//        CafeInfoReview cafeInfoReview = new CafeInfoReview(seq, cafeSeq, openStyle, waitingTime, price, customerNum, plugNum, tableHeight, longStay);
//        cafeInfoReviewMap.put(seq, cafeInfoReview);
//        cafeMap.get(cafeSeq).getCafeInfoReviewList().add(cafeInfoReview);
        cafeInfoReviewService.putCafeInfoReview(cafeSeq, reqCafeInfoReviewCreate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cafe/{cafeSeq}/infoReview")
    public List<CafeInfoReview> getCafeInfoReviewList(@PathVariable("cafeSeq") Long cafeSeq) {
//        return cafeMap.get(cafeSeq).getCafeInfoReviewList();
        return cafeInfoReviewService.getCafeInfoReviewList(cafeSeq);
    }


//    @GetMapping("/cafe/{cafeSeq}/infoReview/{infoReviewSeq}")
//    public CafeInfoReview getCafeInfoReview(@PathVariable("cafeSeq") Integer cafeSeq, @PathVariable("infoReviewSeq") Integer infoReviewSeq) {
//        return cafeMap.get(cafeSeq).getCafeInfoReviewList().get(infoReviewSeq);
//    }
}
