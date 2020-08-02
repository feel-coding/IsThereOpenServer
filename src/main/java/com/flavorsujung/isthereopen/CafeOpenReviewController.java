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

    @GetMapping("/cafeOpenReview/{id}")
    public CafeOpenReview getCafeOpenReview(@PathVariable("id") Integer id) {
        return cafeOpenReviewMap.get(id);
    }

    @GetMapping("/cafeOpenReview/all")
    public List<CafeOpenReview> getUserList() {
        return new ArrayList<CafeOpenReview>(cafeOpenReviewMap.values());
    }

    @PutMapping("/cafeOpenReview/{seq}")
    public void putCafeOpenReview(@PathVariable("seq") Integer seq, @RequestParam("cafeSeq") Integer cafeSeq,@RequestParam("userSeq") Integer userSeq, @RequestParam("openState") Integer openState) {
        CafeOpenReview openReview = new CafeOpenReview(seq, cafeSeq, userSeq, openState);
        cafeOpenReviewMap.put(seq, openReview);
        cafeMap.get(seq).setCurrentState(openState);
        seq++;
    }

    /*@PostMapping("/cafeOpenReview/{id}")
    public void postUser(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        User user = openReviewMap.get(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
    }*/
}
