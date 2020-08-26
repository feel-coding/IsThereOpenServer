package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BarController {
    private final BarService barService;

    @PostConstruct
    public void init() {
        Bar bar = new Bar();
        bar.setName("도시포차");
        bar.setAddress("서울 성북구 동소문로20길 37-6");
        bar.setRunningTime("매일 18:00 - 06:00");
        bar.setPhoneNum("02-921-7233");
        bar.setPhotoUrl( "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fldb.phinf.naver.net%2F20161202_250%2F1480683381497gM2lV_JPEG%2F177152618641360_0.jpeg");
        putBar(bar);
//        putBar("도시포차", "서울 성북구 동소문로20길 37-6", "매일 18:00 - 06:00","02-921-7233", "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fldb.phinf.naver.net%2F20161202_250%2F1480683381497gM2lV_JPEG%2F177152618641360_0.jpeg");
//        putBar("반듯한잔", "서울 성북구 동소문로22길 80", "평일 17:30 - 02:00, 주말 17:30 - 04:00, 매주 수요일 휴무", "02-942-5577", "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fldb.phinf.naver.net%2F20200319_218%2F1584614780723SCdVU_JPEG%2FWl_MfUCe9fGV4uM7kztMgxlZ.jpg");
//        putBar("달밫자전거", "서울 성북구 보문로32길 49", "평일 17:00-04:00, 금요일 17:00-04:00, 토요일 17:00-04:00", "0507-1495-6000", "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fldb.phinf.naver.net%2F20190615_73%2F1560589828187ujcs1_JPEG%2FMHR6GjfhH-z5hK5dTopMKXo0.JPG.jpg");
//        putBar("청춘예찬", "서울 성북구 동소문로20길 29-14", "매일 17:00~04:00 연중무휴", "02-953-2848", "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fldb.phinf.naver.net%2F20171110_67%2F1510319776366LXjSr_JPEG%2F85RWl6M0FqFXtZv8wttK8XGl.jpg");
//        putBar("오늘와인한잔 성신여대점", "서울 성북구 보문로34길 56", "매일 16:00~03:00, 마지막 주문 메뉴2:30 주류2:40","02-6956-1787", "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fldb.phinf.naver.net%2F20190215_298%2F1550199616157ttDKr_JPEG%2FwRGIn4Wpj9Nbox_f_xLKgxz9.jpg");
    }
    @GetMapping("/bar/{barSeq}/openState") // 술집 오픈 여부 조회
    public OpenState getCurrentState(@PathVariable("barSeq") Long barSeq) {
        return barService.getBar(barSeq).getCurrentState();
    }

    @GetMapping("/bar/all") // 술집 리스트 조회
    public List<Bar> getBarList() {
        //return new ArrayList<Bar>(barMap.values());
        return barService.getBarList();
    }

    @GetMapping("/bar/{barSeq}") // 술집 조회
    public Bar getBar(@PathVariable("barSeq") Long barSeq) {
        return barService.getBar(barSeq);
    }

    @PutMapping("/bar") //술집 추가
    public void putBar(@RequestBody Bar bar/*@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("runningTime") String runningTime, @RequestParam("phoneNum") String phoneNum,@RequestParam("photoURL") String photoURL*/) {
        barService.putBar(bar/*name, address, runningTime, phoneNum, photoURL*/);
    }

    @DeleteMapping("/bar")// 술집 삭제
    public void deleteBar(@RequestParam("barSeq") Long barSeq) {
        barService.deleteBar(barSeq);
    }

}
