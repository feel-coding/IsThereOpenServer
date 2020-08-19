package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.User;
import com.flavorsujung.isthereopen.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User getUser(Long userSeq) {
        User user = userRepository.findUserBySeq(userSeq);
        return user;
    }

    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public Long putUser(String name) {
        User user = new User();
        user.setName(name);
        user = userRepository.save(user);
        return user.getSeq();
    }

}
