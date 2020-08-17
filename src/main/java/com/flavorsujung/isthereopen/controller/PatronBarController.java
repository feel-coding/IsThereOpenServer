package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.PatronBar;
import com.flavorsujung.isthereopen.service.PatronBarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatronBarController {
    private final PatronBarService patronBarService;
    @GetMapping("/user/{seq}/patronBar/all")// 단골 술집 리스트 조회 (8/18 API 테스트 완료)
    public List<PatronBar> getPatronBarList(@PathVariable("seq") Long userSeq) {
        return patronBarService.getPatronBarList(userSeq);
    }

    @PutMapping("/user/{seq}/patronBar") // 단골 술집 추가 (8/18 API 테스트 완료)
    public void putPatronBar(@PathVariable("seq") Long userSeq, @RequestParam("barSeq") Long barSeq) {
        patronBarService.putPatronBar(userSeq, barSeq);
    }
}
