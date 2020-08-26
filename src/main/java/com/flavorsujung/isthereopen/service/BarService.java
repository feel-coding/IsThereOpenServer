package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.respository.BarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarService {
    private final BarRepository barRepository;

    public Bar getBar(Long barSeq) {
        return barRepository.findBarBySeq(barSeq);
    }

    public List<Bar> getBarList() {
        return barRepository.findAll();
    }

    public void putBar(Bar bar/*String name, String address, String runningTime, String phoneNum, String photoURL*/) {
       /* Bar bar = new Bar();
        bar.setName(name);
        bar.setPhoneNum(phoneNum);
        bar.setAddress(address);
        bar.setRunningTime(runningTime);
        bar.setPhotoUrl(photoURL);
        bar.setCurrentState(OpenState.UNKNOWN);*/
        bar.setCurrentState(OpenState.UNKNOWN);
        barRepository.save(bar);
    }

    public void postBar(Bar bar) {
        barRepository.save(bar);
    }

    public void deleteBar(Long barSeq) {
        barRepository.deleteBarBySeq(barSeq);
    }
}
