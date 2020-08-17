package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BarRepository extends JpaRepository<Bar, Long> {
    //List<Bar> findAllBar();
    Bar findBarBySeq(Long barSeq);

    @Transactional
    void deleteBarBySeq(Long barSeq);
}
