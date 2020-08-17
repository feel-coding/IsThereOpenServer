package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.service.CafeService;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;
//    public static Map<Long, Cafe> cafeMap;

    @PostConstruct
    public void init() {
//        cafeMap = new HashMap<>();
//        cafeMap.put((long) 0, new Cafe((long) 0, "커피베이 성신여대점", "서울 성북구 보문로34길 80 1층", "매일 10:00 - 23:00", "http://ldb.phinf.naver.net/20190922_46/1569123521799gJEQg_JPEG/lxoQ7YkH0Y3AyedAkNbeKJK6.jpeg.jpg"));
//        cafeMap.put((long) 1, new Cafe((long) 1, "카페비", "서울 성북구 보문로30길 71 ", "매일 11:00 - 24:00", "http://ldb.phinf.naver.net/20151104_44/1446627314732yeCEp_JPEG/167054578530574_21.jpg"));
//        cafeMap.put((long) 2, new Cafe((long) 2, "홀슈", "서울 성북구 보문로34길 88", "오후 12시~오후 8시", "http://ldb.phinf.naver.net/20191002_250/1569986451053OrdX1_JPEG/JcHuVz_SanKstCeTbMuK6O8W.JPG.jpg"));
//        cafeMap.put((long) 3, new Cafe((long) 3, "이디야커피 성신여대점", "서울 성북구 보문로34길 100", "평일 07:30 - 23:00, 주말 08:00 - 23:00, 공휴일 08:00 - 23:00", "http://ldb.phinf.naver.net/20170711_282/1499738599754pJSvu_JPEG/186661513339210_0.jpeg"));
//        cafeMap.put((long) 4, new Cafe((long) 4, "스타벅스 성신여대정문점", "서울 성북구 보문로34길 62", " 08:00 - 21:30", "http://ldb.phinf.naver.net/20190828_93/1566953601239OT9MQ_PNG/xX7Wv642gXMoTI0DAv0hRymS.png"));
//        cafeMap.put((long) 5, new Cafe((long) 5, "카페온더플랜", "서울 성북구 동소문로22길 39-4", "매일 08:00 - 05:00", "http://ldb.phinf.naver.net/20190214_234/1550123304569M0StE_JPEG/omHhVGuluiyH3ye3XAnPu2j1.jpg"));
//        cafeMap.put((long) 6, new Cafe((long) 6, "본크레페", "서울 성북구 동소문로20다길 30", "평일 14:00 - 19:00", "http://ldb.phinf.naver.net/20150813_69/1439473829903KC20W_JPEG/SUBMIT_1439434572823_33646766.jpg"));
        }

    @GetMapping("/cafe/{cafeSeq}/openState") // (8/17 API 테스트 완료)
    public OpenState getCurrentState(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeService.getCafe(cafeSeq).getCurrentState();
    }

    @GetMapping("/cafe/all") // (8/17 API 테스트 완료)
    public List<Cafe> getCafeList() {
        return cafeService.getCafeList();
    }

    @GetMapping("/cafe/{cafeSeq}") // (8/17 API 테스트 완료)
    public Cafe getCafe(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeService.getCafe(cafeSeq);
    }

    @PutMapping("/cafe") //카페 추가 (8/17 API 테스트 완료)
    public void putCafe(@RequestParam("name") String name,
                        @RequestParam("address") String address,
                        @RequestParam("runningTime") String runningTime,
                        @RequestParam("phoneNum") String phoneNum,
                        @RequestParam("photoURL") String photoURL) {
        cafeService.putCafe(name, address, runningTime, phoneNum, photoURL);
    }

    @PostMapping("/cafe/{cafeSeq}") //카페 오픈 여부 수정 (8/17 API 테스트 완료)
    public void postCafeCurrentState(@PathVariable("cafeSeq") Long cafeSeq, @RequestParam("currentState") OpenState currentState) {
        Cafe cafe = cafeService.getCafe(cafeSeq);
        cafe.setCurrentState(currentState);
        cafeService.postCafe(cafe);
    }


}
