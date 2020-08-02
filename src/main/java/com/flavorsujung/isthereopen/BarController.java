package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.CafeOpenReviewController.cafeOpenReviewMap;

@RestController
public class BarController {
    public static Map<Integer, Bar> barMap;
    public static final Integer CLOSE = 0;
    public static final Integer BREAKTIME = 1;
    public static final Integer OPEN = 2;
    public static final Integer UNKNOWN = 3;

    @PostConstruct
    public void init() {
        barMap = new HashMap<>();
        barMap.put(1, new Bar(1, "카페비", "성북구 어쩌구", "오전 9시~오후 11시", 4.5, OPEN));
        barMap.put(2, new Bar(2, "홀슈", "정문 앞", "오후 12시~오후 8시", 4.1, UNKNOWN));
    }

    @GetMapping("/bar/{barSeq}")
    public Integer getCurrentState(@PathVariable("cafeSeq") Integer cafeSeq) {
        return cafeOpenReviewMap.get(cafeSeq).getOpenState();
    }

    @GetMapping("/bar/all")
    public List<Bar> getCafeList() {
        return new ArrayList<Bar>(barMap.values());
    }

    @PutMapping("/bar/{barSeq}")
    public void putBar(@PathVariable("cafeSeq") Integer cafeSeq, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("runtime") String runtime, @RequestParam("rate") Double rate) {
        barMap.put(cafeSeq, new Bar(cafeSeq, name, address, runtime, rate, UNKNOWN));
    }

    @PostMapping("/bar/{barSeq}")
    public void postCurrentState(@PathVariable("cafeSeq") Integer cafeSeq, @RequestParam("openState") Integer openState) {
        cafeOpenReviewMap.get(cafeSeq).setOpenState(openState);
    }
}
