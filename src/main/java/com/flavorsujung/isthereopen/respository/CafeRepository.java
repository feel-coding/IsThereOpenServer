package com.flavorsujung.isthereopen.respository;
import com.flavorsujung.isthereopen.domain.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {
   // List<Cafe> findAllCafe();
    Cafe findCafeBySeq(Integer cafeSeq);
}
