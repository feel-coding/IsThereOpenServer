package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.CafeController.*;

@RestController
public class CafeOpenReviewController {
    private Integer seq = 0;
    public static Map<Integer, CafeOpenReview> cafeOpenReviewMap;

    @PostConstruct
    public void init(){
        cafeOpenReviewMap = new HashMap<>();
        cafeOpenReviewMap.put(1, new CafeOpenReview(1, 1, 2, CLOSE));
        cafeOpenReviewMap.put(2, new CafeOpenReview(2, 2, 1, UNKNOWN));
    }

    @GetMapping("/cafeOpenReview/{seq}")
    public CafeOpenReview getCafeOpenReview(@PathVariable("seq") Integer seq) {
        return cafeOpenReviewMap.get(seq);
    }

    @GetMapping("/cafeOpenReview/{seq}")
    public List<CafeOpenReview> getCafeOpenReviewList(@PathVariable("seq") Integer seq) {
        return new ArrayList<CafeOpenReview>(cafeMap.get(seq).getCafeOpenReviewList());
    }

    @PutMapping("/cafeOpenReview/{seq}")
    public void putCafeOpenReview(@PathVariable("seq") Integer seq, @RequestParam("cafeSeq") Integer cafeSeq, @RequestParam("userSeq") Integer userSeq, @RequestParam("openState") Integer openState) {
        CafeOpenReview openReview = new CafeOpenReview(seq, cafeSeq, userSeq, openState);
        cafeOpenReviewMap.put(seq, openReview);
        cafeMap.get(seq).setCurrentState(openState);
        seq++;
    }
}
