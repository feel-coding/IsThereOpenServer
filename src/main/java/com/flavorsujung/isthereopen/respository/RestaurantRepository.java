package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long>  {
    //List<Restaurant> findAllRestaurant();
    Restaurant findRestaurantBySeq(Long restaurantSeq);

}
