package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

import static com.flavorsujung.isthereopen.CafeController.*;

@RestController
public class CafeOpenReviewController {
    public static Map<Integer, CafeOpenReview> cafeOpenReviewMap;

    @PostConstruct
    public void init(){
        cafeOpenReviewMap = new HashMap<>();
//        cafeOpenReviewMap.put(1, new CafeOpenReview(1, 1, 2, CLOSE));
//        cafeOpenReviewMap.put(2, new CafeOpenReview(2, 2, 1, UNKNOWN));
    }

    @GetMapping("/cafe/{cafeSeq}/openReview")
    public List<CafeOpenReview> getCafeOpenReviewList(@PathVariable("cafeSeq") Integer cafeSeq) {
        return cafeMap.get(cafeSeq).getCafeOpenReviewList();
    }

    @PutMapping("/cafe/{cafeSeq}/openReview")
    public void putCafeOpenReview(@PathVariable("cafeSeq") Integer cafeSeq, @RequestParam("userSeq") Integer userSeq, @RequestParam("openState") Integer openState) {
        int seq = cafeOpenReviewMap.size();
        CafeOpenReview openReview = new CafeOpenReview(seq, cafeSeq, userSeq, openState);
        cafeOpenReviewMap.put(seq, openReview);
        cafeMap.get(seq).getCafeOpenReviewList().add(openReview);
        cafeMap.get(seq).setCurrentState(openState);
        cafeMap.get(seq).setLastUpdate(new Date());
    }
}
