package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.PatronCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatronCafeRepository extends JpaRepository<PatronCafe, Long> {
    List<PatronCafe> findPatronCafesByUserSeq(Long userSeq);

    @Transactional
    void deletePatronCafeByUserSeqAndCafeSeq(Long userSeq, Long cafeSeq);
}
