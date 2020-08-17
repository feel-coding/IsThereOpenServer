package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.PatronBar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatronBarRepository extends JpaRepository<PatronBar, Long> {
    List<PatronBar> findPatronBarsByUserSeq(Long userSeq);
}
