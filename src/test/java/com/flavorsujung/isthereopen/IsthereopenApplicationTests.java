package com.flavorsujung.isthereopen;

import com.flavorsujung.isthereopen.domain.entity.User;
import com.flavorsujung.isthereopen.respository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IsthereopenApplicationTests {

    @Autowired
    UserRepository userRepository;


    @Test
    void contextLoads() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
        /*write하는 거임
        userRepository.save() 안에 User객체 밖에 못들어감
        new 로 해서 seq없어 넣어주면 insert
        파라미터로 seq도 같이 넘겨주면 update
        saveall()여러개 한번에

        userRepository.delete();

        find만 공부하기(find문법 공부가 필요하다.)

User findUserById(Integer seq)
        */
    }



}
