package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.PatronBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatronBarRepository extends JpaRepository<PatronBar, Long> {
    List<PatronBar> findPatronBarsByUserSeq(Long userSeq);

    @Transactional
    void deletePatronBarByUserSeqAndAndBarSeq(Long userSeq, Long barSeq);
}
