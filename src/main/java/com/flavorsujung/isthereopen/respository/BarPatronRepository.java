package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.BarPatron;
import com.flavorsujung.isthereopen.domain.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarPatronRepository extends JpaRepository<BarPatron, Integer> {
}
