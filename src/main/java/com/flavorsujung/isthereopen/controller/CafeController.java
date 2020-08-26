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
        Cafe cafe = new Cafe();
        cafe.setName("본크레페");
        cafe.setAddress("서울 성북구 동소문로20다길 30");
        cafe.setRunningTime("평일 14:00 - 19:00");
        cafe.setPhoneNum("02-923-9633");
        cafe.setPhotoUrl("http://ldb.phinf.naver.net/20150813_69/1439473829903KC20W_JPEG/SUBMIT_1439434572823_33646766.jpg");
        putCafe(cafe);
//        putCafe("커피베이 성신여대점", "서울 성북구 보문로34길 80 1층", "매일 10:00 - 23:00", "0507-1375-2014", "http://ldb.phinf.naver.net/20190922_46/1569123521799gJEQg_JPEG/lxoQ7YkH0Y3AyedAkNbeKJK6.jpeg.jpg");
//        putCafe("카페비", "서울 성북구 보문로30길 71 ", "매일 11:00 - 24:00", "02-921-7797", "http://ldb.phinf.naver.net/20151104_44/1446627314732yeCEp_JPEG/167054578530574_21.jpg");
//        putCafe("홀슈", "서울 성북구 보문로34길 88", "오후 12시~오후 8시", "정보없음", "http://ldb.phinf.naver.net/20191002_250/1569986451053OrdX1_JPEG/JcHuVz_SanKstCeTbMuK6O8W.JPG.jpg");
//        putCafe("이디야커피 성신여대점", "서울 성북구 보문로34길 100", "평일 07:30 - 23:00, 주말 08:00 - 23:00, 공휴일 08:00 - 23:00", "02-925-3738", "http://ldb.phinf.naver.net/20170711_282/1499738599754pJSvu_JPEG/186661513339210_0.jpeg");
//        putCafe("스타벅스 성신여대정문점", "서울 성북구 보문로34길 62", " 08:00 - 21:30", "1522-3232", "http://ldb.phinf.naver.net/20190828_93/1566953601239OT9MQ_PNG/xX7Wv642gXMoTI0DAv0hRymS.png");
//        putCafe("카페온더플랜", "서울 성북구 동소문로22길 39-4", "매일 08:00 - 05:00", "02-6215-1020", "http://ldb.phinf.naver.net/20190214_234/1550123304569M0StE_JPEG/omHhVGuluiyH3ye3XAnPu2j1.jpg");
//        putCafe("본크레페", "서울 성북구 동소문로20다길 30", "평일 14:00 - 19:00", "02-923-9633", "http://ldb.phinf.naver.net/20150813_69/1439473829903KC20W_JPEG/SUBMIT_1439434572823_33646766.jpg");
    }

    @GetMapping("/cafe/{cafeSeq}/openState") // 카페 오픈 여부 조회 (8/17 API 테스트 완료)
    public OpenState getCurrentState(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeService.getCafe(cafeSeq).getCurrentState();
    }

    @GetMapping("/cafe/all") // 카페 리스트 조회 (8/17 API 테스트 완료)
    public List<Cafe> getCafeList() {
        return cafeService.getCafeList();
    }

    @GetMapping("/cafe/{cafeSeq}") // 카페 조회 (8/17 API 테스트 완료)
    public Cafe getCafe(@PathVariable("cafeSeq") Long cafeSeq) {
        return cafeService.getCafe(cafeSeq);
    }

    @PutMapping("/cafe") //카페 추가 (8/17 API 테스트 완료)
    public void putCafe(@RequestBody Cafe cafe) {
        cafeService.putCafe(cafe.getName(), cafe.getAddress(), cafe.getRunningTime(), cafe.getPhoneNum(), cafe.getPhotoUrl());
    }

    @PostMapping("/cafe/{cafeSeq}/name") //카페 이름 변경 (8/18 API 테스트 완료)
    public void updateCafeName(@PathVariable("cafeSeq") Long cafeSeq, @RequestParam("name") String name) {
        Cafe cafe = cafeService.getCafe(cafeSeq);
        cafe.setName(name);
        cafeService.postCafe(cafe);
    }

    @PostMapping("/cafe/{cafeSeq}/runningTime") //카페 운영시간 변경 (8/18 API 테스트 완료)
    public void updateCafeRunningTime(@PathVariable("cafeSeq") Long cafeSeq, @RequestParam("runningTime") String runningTime) {
        Cafe cafe = cafeService.getCafe(cafeSeq);
        cafe.setRunningTime(runningTime);
        cafeService.postCafe(cafe);
    }

    @PostMapping("/cafe/{cafeSeq}/photoUrl") //카페 사진 URL 변경 (8/18 API 테스트 완료)
    public void updateCafePhoto(@PathVariable("cafeSeq") Long cafeSeq, @RequestParam("photoURL") String photoURL) {
        Cafe cafe = cafeService.getCafe(cafeSeq);
        cafe.setPhotoUrl(photoURL);
        cafeService.postCafe(cafe);
    }

    @PostMapping("/cafe/{cafeSeq}/address") //카페 주소 변경 (8/18 API 테스트 완료)
    public void updateCafeAddress(@PathVariable("cafeSeq") Long cafeSeq, @RequestParam("address") String address) {
        Cafe cafe = cafeService.getCafe(cafeSeq);
        cafe.setAddress(address);
        cafeService.postCafe(cafe);
    }

    @DeleteMapping("/cafe") // 카페 삭제 (8/18 API 테스트 완료)
    public void deleteCafe(@RequestParam("cafeSeq") Long cafeSeq) {
        cafeService.deleteCafe(cafeSeq);
    }
}
