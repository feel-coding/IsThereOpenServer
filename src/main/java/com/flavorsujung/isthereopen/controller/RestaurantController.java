package com.flavorsujung.isthereopen.controller;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.service.RestaurantService;
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
public class RestaurantController {
    private final RestaurantService restaurantService;
    public static Map<Long, Restaurant> restaurantMap;

    @PostConstruct
    public void init() {
//        restaurantMap = new HashMap<>();
//        restaurantMap.put(0L, new Restaurant(0L, "이름없는파스타 성신여대점", "서울 성북구 동소문로20다길 33", "매일 11:30 - 20:30", "http://blogfiles.naver.net/MjAyMDA3MDlfMjU5/MDAxNTk0MjkyMDI5MzMw.ZAX8LeKf_eY0Q_Xuv3c4hBt0RU5VzApy2pZew_YDGUUg.5kPPrPx02rAWA3u48-R0uFivGuLhPXVDulDQE6z5gVQg.JPEG.tmfwl6756/KakaoTalk_20200709_183307242_14.jpg"));
//        restaurantMap.put(1L, new Restaurant(1L, "마늘과 올리브 성신여대점", "성북구 동소문로22길 29", "매일 11:00 - 22:00명절 당일 휴무", "http://ldb.phinf.naver.net/20151104_232/1446627390967kmYDH_JPEG/167054578649635_0.jpg"));
//        restaurantMap.put(2L, new Restaurant(2L, "미오지오", "서울 성북구 동소문로24가길 21", "오후 12시~오후 8시", "http://ldb.phinf.naver.net/20170622_62/1498119280128apS3n_JPEG/186569597177939_0.jpeg"));
//        restaurantMap.put(3L, new Restaurant(3L, "해밀", "성북구 동소문로24가길 19", "매일 09:30 - 23:00, 일요일 11:00 - 23:00"));
//        restaurantMap.put(4L, new Restaurant(4L, "최고당돈까스", "서울 성북구 보문로34길 77", " 08:00 - 21:30", "http://ldb.phinf.naver.net/20191112_75/1573542729468PLhMJ_JPEG/jN-aNpRrljfOS4pdDnW4fV23.jpg"));
//        restaurantMap.put(5L, new Restaurant(5L, "제순식당 성신여대점", "서울 성북구 동소문로20다길 30-9", "매일 08:00 - 05:00", "http://ldb.phinf.naver.net/20151104_222/1446627540736dkLpR_JPEG/167054578879147_1.jpg"));
//        restaurantMap.put(6L, new Restaurant(6L, "띵라면", "서울 성북구 동소문로22길 29-8", "매일 11:00~21:00"));
//        restaurantMap.put(7L, new Restaurant(7L, "마녀주방 성신여대점", "서울 성북구 동소문로22길 11 2, 3층", "매일 10:00 - 23:00", "http://ldb.phinf.naver.net/20200624_235/1592971156269CwCTN_JPEG/TFGIfkPp5x4sWyZi9lsoECih.jpg"));
//        restaurantMap.put(8L, new Restaurant(8L, "쵸이양식", "서울 성북구 동소문로20나길 24 2층", "매일 12:00 - 21:00, 매주 일요일 휴무", "http://ldb.phinf.naver.net/20190101_187/154635217293249UVn_JPEG/XlyOJgqlT8jtY4Bzb6c-8_TY.jpeg.jpg"));
        }

    @GetMapping("/restaurant/{restaurantSeq}/openState") // 식당 오픈 여부 조회 (8/18 API 테스트 완료)
    public OpenState getCurrentState(@PathVariable("restaurantSeq") Long restaurantSeq) {
//        return restaurantMap.get(restaurantSeq).getCurrentState();
        return restaurantService.getCurrentState(restaurantSeq);
    }

    @GetMapping("/restaurant/all")//식당 리스트 조회 (8/17 API 테스트 완료)
    public List<Restaurant> getRestaurantList() {
        //return new ArrayList<Restaurant>(restaurantMap.values());
        return restaurantService.getRestaurantList();
    }

    @PutMapping("/restaurant") //식당 추가 (8/17 API 테스트 완료)
    public void putRestaurant(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("runningTime") String runningTime,
            @RequestParam("phoneNum") String phoneNum,
            @RequestParam("photoURL") @Nullable String photoUrl) {
        restaurantService.putRestaurant(name, address, runningTime, phoneNum, photoUrl);
    }

    @GetMapping("/restaurant/{restaurantSeq}")//식당 조회 (8/17 API 테스트 완료)
    public Restaurant getRestaurant(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantService.getRestaurant(restaurantSeq);
    }

    @DeleteMapping("/restaurant") // 식당 삭제 (8/18 API 테스트 완료)
    public void deleteRestaurant(Long restaurantSeq) {
        restaurantService.deleteRestaurant(restaurantSeq);
    }

}
