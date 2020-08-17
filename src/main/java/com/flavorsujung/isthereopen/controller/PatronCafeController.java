package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.PatronCafe;
import com.flavorsujung.isthereopen.service.PatronCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatronCafeController {
    private final PatronCafeService patronCafeService;

    @GetMapping("/user/{seq}/patronCafe/all") //단골 카페 리스트 조회 (8/18 API 테스트 완료)
    public List<PatronCafe> getPatronCafeList(@PathVariable("seq") Long userSeq) {
        return patronCafeService.getPatronCafeList(userSeq);
    }

    @PutMapping("/user/{seq}/patronCafe") // 단골 카페 추가 (8/18 API 테스트 완료)
    public void putPatronCafe(@PathVariable("seq") Long userSeq, @RequestParam("cafeSeq") Long cafeSeq) {
        patronCafeService.putPatronCafe(userSeq, cafeSeq);
    }
}
