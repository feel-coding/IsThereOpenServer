package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.respository.BarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarService {
    private final BarRepository barRepository;

    public Bar getBar(Integer barSeq) {
        Bar bar = barRepository.findBarBySeq(barSeq);
        return bar;
    }

    public List<Bar> getBarList() {
        List<Bar> barList = barRepository.findAll();
        return barList;
    }
}
