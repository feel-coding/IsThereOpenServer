package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.PatronRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatronRestaurantRepository extends JpaRepository<PatronRestaurant, Long> {
    List<PatronRestaurant> findPatronRestaurantsByUserSeq(Long userSeq);
}
