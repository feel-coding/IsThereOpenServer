package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.Restaurant;
import com.flavorsujung.isthereopen.domain.entity.User;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.respository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant getRestaurant(Long seq) {
        return restaurantRepository.findRestaurantBySeq(seq);
    }
    public List<Restaurant> getRestaurantList() {
        return restaurantRepository.findAll();
    }

    public OpenState getCurrentState(Long seq) {
        Restaurant restaurant = restaurantRepository.findRestaurantBySeq(seq);
        return restaurant.getCurrentState();
    }
}
