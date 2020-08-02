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
    private Integer seq = 0;
    public static Map<Integer, BarOpenReview> barOpenReviewMap;
    @PostConstruct
    public void init(){
        barOpenReviewMap = new HashMap<>();
        barOpenReviewMap.put(1, new BarOpenReview(1, 1, 2, CLOSE));
        barOpenReviewMap.put(2, new BarOpenReview(2, 2, 1, UNKNOWN));
    }

    @GetMapping("/barOpenReview/{seq}")
    public BarOpenReview getBarOpenReview(@PathVariable("seq") Integer id) {
        return barOpenReviewMap.get(seq);
    }

    @GetMapping("/barOpenReview/all")
    public List<BarOpenReview> getBarOpenReviewList() {
        return new ArrayList<BarOpenReview>(barOpenReviewMap.values());
    }

    @PutMapping("/barOpenReview/{seq}")
    public void putBarOpenReview(@PathVariable("seq") Integer seq, @RequestParam("barSeq") Integer barSeq, @RequestParam("userSeq") Integer userSeq, @RequestParam("openState") Integer openState) {
        BarOpenReview openReview = new BarOpenReview(seq, barSeq, userSeq, openState);
        barOpenReviewMap.put(seq, openReview);
        barMap.get(seq).setCurrentState(openState);
        seq++;
    }
}
