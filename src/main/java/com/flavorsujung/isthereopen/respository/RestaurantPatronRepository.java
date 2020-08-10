package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.Cafe;
import com.flavorsujung.isthereopen.domain.entity.RestaurantPatron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantPatronRepository extends JpaRepository<RestaurantPatron, Integer> {
}
