package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.BarController.*;

@RestController
public class BarOpenReviewController {
    public static Map<Integer, BarOpenReview> barOpenReviewMap;
    @PostConstruct
    public void init(){
        barOpenReviewMap = new HashMap<>();
        barOpenReviewMap.put(0, new BarOpenReview(1, 1, 2, CLOSE));
        barOpenReviewMap.put(1, new BarOpenReview(2, 2, 1, UNKNOWN));
    }

    @GetMapping("/bar/{seq}/openReview")
    public List<BarOpenReview> getBarOpenReviewList() {
        return new ArrayList<BarOpenReview>(barOpenReviewMap.values());
    }

    @PutMapping("/bar/{barSeq}/openReview")
    public void putBarOpenReview(@PathVariable("barSeq") Integer barSeq, @RequestParam("userSeq") Integer userSeq, @RequestParam("openState") Integer openState) {
        int seq = barMap.size();
        BarOpenReview openReview = new BarOpenReview(seq, barSeq, userSeq, openState);
        barOpenReviewMap.put(seq, openReview);
        barMap.get(barSeq).setCurrentState(openState);
    }
}
