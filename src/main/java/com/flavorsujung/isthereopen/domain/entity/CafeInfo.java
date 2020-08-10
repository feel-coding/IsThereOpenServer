package com.flavorsujung.isthereopen.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
@Table(name = "cafe_info")
public class CafeInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer seq;
    Integer openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
    Integer waitingTime;
    Integer price; //0 쌈, 1 보통, 2 비쌈
    Integer customerNum; // 0 적음, 1 보통, 2 많음
    Integer plugNum; // 0 적음, 1 보통, 2 많음
    Integer tableHeight; //0 낮음, 1 보통, 2 높음
    Integer longStay; // 0 가능, 1 보통, 2 눈치보임

}
