package com.flavorsujung.isthereopen.respository;
import com.flavorsujung.isthereopen.domain.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe,Long> {

    Cafe findCafeBySeq(Long cafeSeq);

    @Transactional
    void deleteCafeBySeq(Long cafeSeq);
}
