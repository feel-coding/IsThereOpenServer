package com.flavorsujung.isthereopen.respository;

import com.flavorsujung.isthereopen.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    //List<User> findAllUser();
    User findUserBySeq(Long userSeq);

    User findUserByName(String name);

    /*User findUserBySeq(Integer seq)
    SELECT * FROM user WHERE seq = #{seq}*

    User findUserBySeqAndName(Integer seq, String name);
SELECT * FROM user WHERE seq = #{seq} AND name = #{name}

쿼리를 적지않고 함수명의 규칙을 맞추어주면 알아서 쿼리가 지어진다.
간단한 쿼리는 편리하지만 조인은 안된다. n+1으로 조인없이도 가능하긴 함,..
QueryDSL 꼭 사용하기!

created_at updated_at은 따로 표기한다.
     */
    /*User findUserById(Integer seq)*/
}
