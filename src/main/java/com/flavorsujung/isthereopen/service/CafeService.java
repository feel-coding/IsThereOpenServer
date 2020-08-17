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

    public void putCafe(String name, String address, String runningTime, String phoneNum, String photoUrl) {
        Cafe cafe = new Cafe();
        cafe.setName(name);
        cafe.setAddress(address);
        cafe.setRunningTime(runningTime);
        cafe.setPhoneNum(phoneNum);
        cafe.setPhotoUrl(photoUrl);
        cafe.setCurrentState(OpenState.UNKNOWN);
    }
}
