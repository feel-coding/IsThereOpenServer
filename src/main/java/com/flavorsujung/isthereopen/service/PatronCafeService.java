package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.PatronCafe;
import com.flavorsujung.isthereopen.respository.PatronCafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronCafeService {
    private final PatronCafeRepository patronCafeRepository;

    public List<PatronCafe> getPatronCafeList(Long userSeq) {
        return patronCafeRepository.findPatronCafesByUserSeq(userSeq);
    }

    public void putPatronCafe(Long userSeq, Long cafeSeq){
        PatronCafe patronCafe = new PatronCafe();
        patronCafe.setCafeSeq(cafeSeq);
        patronCafe.setUserSeq(userSeq);
        patronCafeRepository.save(patronCafe);
    }
    public void deletePatronCafe(Long userSeq, Long cafeSeq) {
        patronCafeRepository.deletePatronCafeByUserSeqAndCafeSeq(userSeq, cafeSeq);
    }

}
