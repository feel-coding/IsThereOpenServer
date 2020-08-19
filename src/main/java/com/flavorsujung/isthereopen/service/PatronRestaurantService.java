package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.PatronCafe;
import com.flavorsujung.isthereopen.domain.entity.PatronRestaurant;
import com.flavorsujung.isthereopen.respository.PatronRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronRestaurantService {
    private final PatronRestaurantRepository patronRestaurantRepository;
    public List<PatronRestaurant> getPatronRestaurantList(Long userSeq) {
        return patronRestaurantRepository.findPatronRestaurantsByUserSeq(userSeq);
    }
    public void putPatronRestaurant(Long userSeq, Long restaurantSeq){
        PatronRestaurant patronRestaurant = new PatronRestaurant();
        patronRestaurant.setRestaurantSeq(restaurantSeq);
        patronRestaurant.setUserSeq(userSeq);
        patronRestaurantRepository.save(patronRestaurant);
    }

    public void deletePatronRestaurant(Long userSeq, Long restaurantSeq) {
        patronRestaurantRepository.deletePatronRestaurantByUserSeqAndRestaurantSeq(userSeq, restaurantSeq);
    }
}
