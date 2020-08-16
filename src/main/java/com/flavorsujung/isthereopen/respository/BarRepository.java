package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarRepository extends JpaRepository<Bar, Integer> {
    //List<Bar> findAllBar();
    Bar findBarBySeq(Integer barSeq);
}
