package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.PatronRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatronRestaurantRepository extends JpaRepository<PatronRestaurant, Long> {
    List<PatronRestaurant> findPatronRestaurantsByUserSeq(Long userSeq);

    @Transactional
    void deletePatronRestaurantByUserSeqAndRestaurantSeq(Long userSeq, Long restaurantSeq);
}
