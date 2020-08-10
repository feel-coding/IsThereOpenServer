package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Integer> {
}
