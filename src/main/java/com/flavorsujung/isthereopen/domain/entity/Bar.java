package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStyleConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
public class Bar {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;
    private String name;
    private String address;
    private String phoneNum;
    private String runningTime;
    private Double avgRate;
    @Convert(converter = OpenStateConverter.class)
    private OpenState currentState;
    private String photoUrl;
    private Date lastUpdate;
    private String avgToilet;
    private String avgMood;
    private String avgMainAlcohol;
    private String avgPrice;
    private String avgCleanness;
    private String avgOpenStyle;
    private Integer separate;
    private Integer notLoud;
    private Integer cheap;
    private Integer soju;
    private Integer beer;
    private Integer wine;
    private Integer makgeolli;
    private Integer vodka;
    private Integer clean;
    private Integer stable;

}
