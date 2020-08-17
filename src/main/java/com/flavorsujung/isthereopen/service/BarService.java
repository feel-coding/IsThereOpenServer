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
        Bar bar = barRepository.findBarBySeq(barSeq);
        return bar;
    }

    public List<Bar> getBarList() {
        List<Bar> barList = barRepository.findAll();
        return barList;
    }

    public void putBar(String name, String address, String runningTime, String phoneNum, String photoURL) {
        Bar bar = new Bar();
        bar.setName(name);
        bar.setPhoneNum(phoneNum);
        bar.setAddress(address);
        bar.setRunningTime(runningTime);
        bar.setPhotoUrl(photoURL);
        bar.setCurrentState(OpenState.UNKNOWN);
        barRepository.save(bar);
    }


}
