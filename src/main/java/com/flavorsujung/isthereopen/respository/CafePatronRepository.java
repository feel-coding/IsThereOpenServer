package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.entity.CafePatron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafePatronRepository extends JpaRepository<CafePatron, Integer> {
}
