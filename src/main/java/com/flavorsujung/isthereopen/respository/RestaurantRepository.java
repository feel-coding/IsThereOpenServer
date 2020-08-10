package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>  {
}
