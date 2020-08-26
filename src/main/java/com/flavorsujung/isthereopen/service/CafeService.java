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
        cafeRepository.save(cafe);
    }
    public void postCafe(Cafe cafe) { //카페 정보 수정
        cafeRepository.save(cafe);
    }

    public void deleteCafe(Long cafeSeq) {
        cafeRepository.deleteCafeBySeq(cafeSeq);
    }
}
