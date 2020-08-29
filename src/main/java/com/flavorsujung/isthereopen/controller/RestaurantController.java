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
        Restaurant restaurant = new Restaurant();
        restaurant.setName("이름없는파스타 성신여대점");
        restaurant.setAddress("서울 성북구 동소문로20다길 33");
        restaurant.setRunningTime("매일 11:30 - 20:30");
        restaurant.setPhoneNum("070-8860-9171");
        restaurant.setPhotoUrl("http://blogfiles.naver.net/MjAyMDA3MDlfMjU5/MDAxNTk0MjkyMDI5MzMw.ZAX8LeKf_eY0Q_Xuv3c4hBt0RU5VzApy2pZew_YDGUUg.5kPPrPx02rAWA3u48-R0uFivGuLhPXVDulDQE6z5gVQg.JPEG.tmfwl6756/KakaoTalk_20200709_183307242_14.jpg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("마늘과 올리브 성신여대점");
        restaurant.setAddress("성북구 동소문로22길 29");
        restaurant.setRunningTime("매일 11:00 - 22:00 명절 당일 휴무");
        restaurant.setPhoneNum("02-929-6604");
        restaurant.setPhotoUrl("http://ldb.phinf.naver.net/20151104_232/1446627390967kmYDH_JPEG/167054578649635_0.jpg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("미오지오");
        restaurant.setAddress("서울 성북구 동소문로24가길 21");
        restaurant.setRunningTime("오후 12시~오후 8시");
        restaurant.setPhoneNum("02-953-4535");
        restaurant.setPhotoUrl("http://ldb.phinf.naver.net/20170622_62/1498119280128apS3n_JPEG/186569597177939_0.jpeg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("해밀");
        restaurant.setAddress("성북구 동소문로24가길 19");
        restaurant.setRunningTime("매일 09:30 - 23:00, 일요일 11:00 - 23:00");
        restaurant.setPhoneNum("02-922-5541");
        restaurant.setPhotoUrl("http://blogfiles.naver.net/MjAyMDA4MDdfMjI1/MDAxNTk2Nzc3MDg5NjAw.tgv_yfNF_5HmRRM7QUwkcEHsLJ5AEOfWP4W413vHxNUg.63XEjIXGnrLuRgpj6BM2IvkKm_R5NQReKyA4yMS0cTMg.JPEG.dnfekf55/IMG_9934.jpg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("최고당돈까스");
        restaurant.setAddress("서울 성북구 보문로34길 77");
        restaurant.setRunningTime("08:00 - 21:30");
        restaurant.setPhoneNum("02-921-8822");
        restaurant.setPhotoUrl("http://ldb.phinf.naver.net/20191112_75/1573542729468PLhMJ_JPEG/jN-aNpRrljfOS4pdDnW4fV23.jpg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("제순식당 성신여대점");
        restaurant.setAddress("서울 성북구 동소문로20다길 30-9");
        restaurant.setRunningTime("매일 08:00 - 05:00");
        restaurant.setPhoneNum("02-927-2007");
        restaurant.setPhotoUrl("http://ldb.phinf.naver.net/20151104_222/1446627540736dkLpR_JPEG/167054578879147_1.jpg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("띵라면");
        restaurant.setAddress("서울 성북구 동소문로22길 29-8");
        restaurant.setRunningTime("매일 11:00~21:00");
        restaurant.setPhoneNum("정보없음");
        restaurant.setPhotoUrl("http://blogfiles.naver.net/MjAxODA5MTlfMTMw/MDAxNTM3MzMwNzcxMjY4.swjn9Ucc0J5wG2mlC08LS7Bzev9KXvzjAftK-YsNcTog.uXHMe-Da2KnGGeufHfP6VpU2rgA_KwDs-Kto4fQTJWUg.JPEG.aram331/20180918_131634.jpg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("마녀주방 성신여대점");
        restaurant.setAddress("서울 성북구 동소문로22길 11 2, 3층");
        restaurant.setRunningTime("매일 10:00 - 23:00");
        restaurant.setPhoneNum("02-6349-1116");
        restaurant.setPhotoUrl("http://ldb.phinf.naver.net/20200624_235/1592971156269CwCTN_JPEG/TFGIfkPp5x4sWyZi9lsoECih.jpg");
        putRestaurant(restaurant);
        restaurant = new Restaurant();
        restaurant.setName("쵸이양식");
        restaurant.setAddress("서울 성북구 동소문로20나길 24 2층");
        restaurant.setRunningTime("매일 12:00 - 21:00, 매주 일요일 휴무");
        restaurant.setPhoneNum("010-6408-9639");
        restaurant.setPhotoUrl("http://ldb.phinf.naver.net/20190101_187/154635217293249UVn_JPEG/XlyOJgqlT8jtY4Bzb6c-8_TY.jpeg.jpg");
        putRestaurant(restaurant);
//        putRestaurant("이름없는파스타 성신여대점", "서울 성북구 동소문로20다길 33", "매일 11:30 - 20:30", "070-8860-9171", "http://blogfiles.naver.net/MjAyMDA3MDlfMjU5/MDAxNTk0MjkyMDI5MzMw.ZAX8LeKf_eY0Q_Xuv3c4hBt0RU5VzApy2pZew_YDGUUg.5kPPrPx02rAWA3u48-R0uFivGuLhPXVDulDQE6z5gVQg.JPEG.tmfwl6756/KakaoTalk_20200709_183307242_14.jpg");
//        putRestaurant("마늘과 올리브 성신여대점", "성북구 동소문로22길 29", "매일 11:00 - 22:00 명절 당일 휴무", "02-929-6604", "http://ldb.phinf.naver.net/20151104_232/1446627390967kmYDH_JPEG/167054578649635_0.jpg");
//        putRestaurant("미오지오", "서울 성북구 동소문로24가길 21", "오후 12시~오후 8시", "02-953-4535", "http://ldb.phinf.naver.net/20170622_62/1498119280128apS3n_JPEG/186569597177939_0.jpeg");
//        putRestaurant("해밀", "성북구 동소문로24가길 19", "매일 09:30 - 23:00, 일요일 11:00 - 23:00", "02-922-5541", "http://blogfiles.naver.net/MjAyMDA4MDdfMjI1/MDAxNTk2Nzc3MDg5NjAw.tgv_yfNF_5HmRRM7QUwkcEHsLJ5AEOfWP4W413vHxNUg.63XEjIXGnrLuRgpj6BM2IvkKm_R5NQReKyA4yMS0cTMg.JPEG.dnfekf55/IMG_9934.jpg");
//        putRestaurant("최고당돈까스", "서울 성북구 보문로34길 77", "08:00 - 21:30", "02-921-8822", "http://ldb.phinf.naver.net/20191112_75/1573542729468PLhMJ_JPEG/jN-aNpRrljfOS4pdDnW4fV23.jpg");
//        putRestaurant("제순식당 성신여대점", "서울 성북구 동소문로20다길 30-9", "매일 08:00 - 05:00", "02-927-2007", "http://ldb.phinf.naver.net/20151104_222/1446627540736dkLpR_JPEG/167054578879147_1.jpg");
//        putRestaurant("띵라면", "서울 성북구 동소문로22길 29-8", "매일 11:00~21:00", "정보 없음", "http://blogfiles.naver.net/MjAxODA5MTlfMTMw/MDAxNTM3MzMwNzcxMjY4.swjn9Ucc0J5wG2mlC08LS7Bzev9KXvzjAftK-YsNcTog.uXHMe-Da2KnGGeufHfP6VpU2rgA_KwDs-Kto4fQTJWUg.JPEG.aram331/20180918_131634.jpg");
//        putRestaurant("마녀주방 성신여대점", "서울 성북구 동소문로22길 11 2, 3층", "매일 10:00 - 23:00", "02-6349-1116", "http://ldb.phinf.naver.net/20200624_235/1592971156269CwCTN_JPEG/TFGIfkPp5x4sWyZi9lsoECih.jpg");
//        putRestaurant("쵸이양식", "서울 성북구 동소문로20나길 24 2층", "매일 12:00 - 21:00, 매주 일요일 휴무", "010-6408-9639", "http://ldb.phinf.naver.net/20190101_187/154635217293249UVn_JPEG/XlyOJgqlT8jtY4Bzb6c-8_TY.jpeg.jpg");
    }

    @GetMapping("/restaurant/{restaurantSeq}/openState") // 식당 오픈 여부 조회
    public OpenState getCurrentState(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantService.getCurrentState(restaurantSeq);
    }

    @GetMapping("/restaurant/all")//식당 리스트 조회
    public List<Restaurant> getRestaurantList() {
        return restaurantService.getRestaurantList();
    }

    @PutMapping("/restaurant") //식당 추가
    public void putRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.putRestaurant(restaurant);
    }

    @GetMapping("/restaurant/{restaurantSeq}")//식당 조회
    public Restaurant getRestaurant(@PathVariable("restaurantSeq") Long restaurantSeq) {
        return restaurantService.getRestaurant(restaurantSeq);
    }

    @DeleteMapping("/restaurant") // 식당 삭제
    public void deleteRestaurant(@RequestParam("restaurantSeq") Long restaurantSeq) {
        restaurantService.deleteRestaurant(restaurantSeq);
    }

}
