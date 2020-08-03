package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.CafeOpenReviewController.cafeOpenReviewMap;

@RestController
public class CafeController {
    public static Map<Integer, Cafe> cafeMap;
    public static final Integer CLOSE = 0;
    public static final Integer BREAKTIME = 1;
    public static final Integer OPEN = 2;
    public static final Integer UNKNOWN = 3;

    @PostConstruct
    public void init() {
        cafeMap = new HashMap<>();cafeMap.put(0, new Cafe(0, "커피베이 성신여대점", "서울 성북구 보문로34길 80 1층", "매일 10:00 - 23:00", 4.2, CLOSE));
        cafeMap.put(1, new Cafe(1, "카페비", "서울 성북구 보문로30길 71 ", "매일 11:00 - 24:00", 4.5, CLOSE));
        cafeMap.put(2, new Cafe(2, "홀슈", "서울 성북구 보문로34길 88", "오후 12시~오후 8시", 4.1, UNKNOWN));
        cafeMap.put(3, new Cafe(3, "이디야커피 성신여대점", "서울 성북구 보문로34길 100", "평일 07:30 - 23:00, 주말 08:00 - 23:00, 공휴일 08:00 - 23:00", 4.9, CLOSE));
        cafeMap.put(4, new Cafe(4, "스타벅스 성신여대정문점", "서울 성북구 보문로34길 62", " 08:00 - 21:30", 4.1, OPEN));
        cafeMap.put(5, new Cafe(5, "카페온더플랜", "서울 성북구 동소문로22길 39-4", "매일 08:00 - 05:00", 4.2, OPEN));
        cafeMap.put(6, new Cafe(6, "본크레페", "서울 성북구 동소문로20다길 30", "평일 14:00 - 19:00", 4.9, CLOSE));
        }

    @GetMapping("/cafe/{cafeSeq}/openState") // (API 테스트 완료)
    public Integer getCurrentState(@PathVariable("cafeSeq") Integer cafeSeq) {
        return cafeMap.get(cafeSeq).getCurrentState();
    }

    @GetMapping("/cafe/all") // (API 테스트 완료)
    public List<Cafe> getCafeList() {
        return new ArrayList<Cafe>(cafeMap.values());
    }

    @GetMapping("/cafe/{cafeSeq}") // (API 테스트 완료)
    public Cafe getCafe(@PathVariable("cafeSeq") Integer cafeSeq) {
        return cafeMap.get(cafeSeq);
    }

    @PutMapping("/cafe") //(API 테스트 완료)
    public void putCafe(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("runtime") String runningTime) {
        int seq = cafeMap.size();
        cafeMap.put(seq, new Cafe(seq, name, address, runningTime, 0.0, UNKNOWN));
    }

    @PostMapping("/cafe/{cafeSeq}") //(API 테스트 완료)
    public void postCurrentState(@PathVariable("cafeSeq") Integer cafeSeq, @RequestParam("openState") Integer openState) {
        cafeMap.get(cafeSeq).setCurrentState(openState);
    }
}
