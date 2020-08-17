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
//    public static Map<Long, Bar> barMap;

    @PostConstruct
    public void init() {
//        barMap = new HashMap<>();
    }
    @GetMapping("/bar/{barSeq}/openState") // 술집 오픈 여부 조회 (8/18 API 테스트 완료)
    public OpenState getCurrentState(@PathVariable("barSeq") Long barSeq) {
//        return barMap.get(barSeq).getCurrentState();
        return barService.getBar(barSeq).getCurrentState();
    }

    @GetMapping("/bar/all") // 술집 리스트 조회 (8/18 API 테스트 완료)
    public List<Bar> getBarList() {
        //return new ArrayList<Bar>(barMap.values());
        return barService.getBarList();
    }

    @GetMapping("/bar/{barSeq}") // 술집 조회 (8/18 API 테스트 완료)
    public Bar getBar(@PathVariable("barSeq") Long barSeq) {
        return barService.getBar(barSeq);
    }

    @PutMapping("/bar") //술집 추가 (8/18 API 테스트 완료)
    public void putBar(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("runningTime") String runningTime, @RequestParam("phoneNum") String phoneNum,@RequestParam("photoURL") String photoURL) {
//        Long seq = (long)(barMap.size());
//        barMap.put(seq, new Bar(seq, name, address, runningTime));
        barService.putBar(name, address, runningTime, phoneNum, photoURL);
    }

}
