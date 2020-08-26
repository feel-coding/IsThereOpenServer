package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.respository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;

    public Cafe getCafe(Long cafeSeq) {
        Cafe cafe = cafeRepository.findCafeBySeq(cafeSeq);
        return cafe;
    }

    public List<Cafe> getCafeList() {
        return cafeRepository.findAll();
    }

    public void putCafe(Cafe cafe) {
        cafe.setCurrentState(OpenState.UNKNOWN);
        cafe.setAvgWaitingTime("정보 없음");
        cafe.setAvgCustomerNum("정보 없음");
        cafe.setAvgPrice("정보 없음");
        cafe.setAvgPlugNum("정보 없음");
        cafe.setAvgTableHeight("정보 없음");
        cafe.setAvgLightness("정보 없음");
        cafe.setAvgStayLong("정보 없음");
        cafeRepository.save(cafe);
    }
    public void postCafe(Cafe cafe) { //카페 정보 수정
        cafeRepository.save(cafe);
    }

    public void deleteCafe(Long cafeSeq) {
        cafeRepository.deleteCafeBySeq(cafeSeq);
    }
}
