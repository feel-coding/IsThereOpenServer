package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.CafeController.cafeMap;

@RestController
public class CafeInfoReviewController {
    Map<Integer, CafeInfoReview> cafeInfoReviewMap;

    @PostConstruct
    public void init() {
        cafeInfoReviewMap = new HashMap<>();
    }

    @PutMapping("/cafeInfoReview/{cafeSeq}")
    public void putCafeInfoReview(
            @PathVariable("cafeSeq") Integer cafeSeq,
            @RequestParam("openStyle") Integer openStyle,
            @RequestParam("waitingTime") Integer waitingTime,
            @RequestParam("price") Integer price,
            @RequestParam("customerNum") Integer customerNum,
            @RequestParam("plugNum") Integer plugNum,
            @RequestParam("tableHeight") Integer tableHeight,
            @RequestParam("longStay") Integer longStay) {
        int seq = cafeInfoReviewMap.size();
        cafeInfoReviewMap.put(seq, new CafeInfoReview(seq, cafeSeq, openStyle, waitingTime, price, customerNum, plugNum, tableHeight, longStay));
    }

    @GetMapping("/cafeInfoReview/{cafeSeq}")
    public List<CafeInfoReview> getCafeInfoReviewList(@PathVariable("cafeSeq") Integer cafeSeq) {
        return cafeMap.get(cafeSeq).getCafeInfoReviewList();
    }
}
