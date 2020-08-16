package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.respository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;

    public Cafe getCafe(Integer cafeSeq) {
        Cafe cafe = cafeRepository.findCafeBySeq(cafeSeq);
        return cafe;
    }

    public List<Cafe> getCafeList() {
        return cafeRepository.findAll();
    }
}
