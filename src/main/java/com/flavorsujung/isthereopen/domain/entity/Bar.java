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

}
