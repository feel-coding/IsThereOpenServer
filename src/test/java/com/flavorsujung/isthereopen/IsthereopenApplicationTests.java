package com.flavorsujung.isthereopen;

import com.flavorsujung.isthereopen.domain.entity.Bar;
import com.flavorsujung.isthereopen.domain.entity.BarInfoReview;
import com.flavorsujung.isthereopen.domain.entity.User;
import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.flavorsujung.isthereopen.respository.BarInfoReviewRepository;
import com.flavorsujung.isthereopen.respository.BarRepository;
import com.flavorsujung.isthereopen.respository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

import java.util.List;

@SpringBootTest
class IsthereopenApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BarRepository barRepository;

    @Autowired
    BarRepository barInfoRepository;


    @Autowired
    BarInfoReviewRepository barInfoReviewRepository;



    @Test
    void contextLoads() {

        //User 검사코드
//        List<User> userList = userRepository.findAll();
//        System.out.println(userList);
//        User user = new User();
//        user.setName("봉봉이");
//        userRepository.save(user);
//        System.out.println(user); //name말고 다른게 자동으로 등록됨
//        //save한다음에 seq값을 써야한다. 저절로 seq가 들어가있는지 확인한다.
//
//        System.out.println(userList);
//
//        userRepository.delete(user);

       /* List<BarInfoReview> barInfoReviewList = barInfoReviewRepository.findAll();*/


        Bar bar = new Bar((long)0, "육회본가", "성북구 어쩌구","오전 9시~오후 11시");
        barRepository.save(bar);
        System.out.println(bar);

        /*BarInfoReview barInfoReview = new BarInfoReview();
        barInfoReview.setUserSeq((long)1);
        barInfoReview.setBarSeq((long)0);
        barInfoReview.setMainAlcohol(Alcohol.SOJU);
        barInfoReview.setPrice(Price.CHEAP);
        barInfoReview.setOpenStyle(OpenStyle.NORMAL);
        barInfoReview.setCleanness(Cleanness.CLEAN);
        barInfoReview.setMood(Mood.LOUD);
        barInfoReviewRepository.save(barInfoReview);
        System.out.println(barInfoReview);*/
        //무드를 설정한다.

        //헤더명(이거 꼭 해야함)
        //HttpHeaders.AUTHORIZATION();

        //수정해야할때 조회를 하지 않고 속성값을 바꾸고 싶으면 나머지값들은 모두 null로 한다.


        //조회해서 바꾸기(동동이 이름을 둥둥이로 바꾼다.)


        //
        /*write하는 거임
//        userRepository.save() 안에 User객체 밖에 못들어감
        new 로 해서 seq없어 넣어주면 insert
        파라미터로 seq도 같이 넘겨주면 update
        saveall()여러개 한번에

        userRepository.delete();

        find만 공부하기(find문법 공부가 필요하다.)

User findUserById(Integer seq)
        */
    }
}
