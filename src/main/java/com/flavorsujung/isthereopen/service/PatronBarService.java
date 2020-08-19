package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.PatronBar;
import com.flavorsujung.isthereopen.domain.entity.PatronCafe;
import com.flavorsujung.isthereopen.respository.PatronBarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronBarService {
    private final PatronBarRepository patronBarRepository;

    public List<PatronBar> getPatronBarList(Long userSeq) {
        return patronBarRepository.findPatronBarsByUserSeq(userSeq);
    }
    public void putPatronBar(Long userSeq, Long barSeq){
        PatronBar patronBar = new PatronBar();
        patronBar.setBarSeq(barSeq);
        patronBar.setUserSeq(userSeq);
        patronBarRepository.save(patronBar);
    }

    public void deleteBar(Long userSeq, Long barSeq) {
        patronBarRepository.deletePatronBarByUserSeqAndAndBarSeq(userSeq, barSeq);
    }
}
