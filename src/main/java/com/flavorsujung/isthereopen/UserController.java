package com.flavorsujung.isthereopen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flavorsujung.isthereopen.BarController.barMap;

@RestController
public class UserController {
    private Map<Integer, User> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<>();
        userMap.put(1, new User(1, "hek0628", "김효은"));
        userMap.put(2, new User(2, "yeokyeong", "윤여경"));
        userMap.put(3, new User(3, "seol", "박설"));
    }

    @GetMapping("/user/{seq}")
    public User getUser(@PathVariable("seq") Integer seq) {
        return userMap.get(seq);
    }

    @GetMapping("/user/all")
    public List<User> getUserList() {
        return new ArrayList<User>(userMap.values());
    }

    @PutMapping("/user/{seq}")
    public void putUser(@PathVariable("seq") Integer seq, @RequestParam("id") String id, @RequestParam("name") String name) {
        User user = new User(seq, id, name);
        userMap.put(seq, user);
    }

    @PostMapping("/user/{seq}")
    public void postUser(@PathVariable("seq") Integer seq, @RequestParam("id") String id, @RequestParam("name") String name) {
        User user = userMap.get(seq);
        user.setName(name);
    }

    @GetMapping("/user/{seq}/patronBar")
    public List<Bar> getPatronBarList(@PathVariable("userSeq") Integer userSeq) {
        List<Integer> patronBarSeqList = userMap.get(userSeq).getPatronBarList();
        List<Bar> patronBarList = new ArrayList<>();
        for(Integer i : patronBarSeqList) {
            patronBarList.add(barMap.get(i));
        }
        return patronBarList;
    }
}
