package com.flavorsujung.isthereopen.service;

import com.flavorsujung.isthereopen.domain.entity.User;
import com.flavorsujung.isthereopen.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User getUser(Integer userSeq) {
        User user = userRepository.findUserBySeq(userSeq);
        return user;
    }

    public List<User> getUserList() {
        List<User> userList = userRepository.findAllUser();
        return userList;
    }

}
