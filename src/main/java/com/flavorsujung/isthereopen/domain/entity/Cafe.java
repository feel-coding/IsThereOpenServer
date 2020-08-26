package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.*;
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
public class Cafe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;
    private String name;
    private String address;
    private String phoneNum;
    private String runningTime;
    private Double avgRate;
    private OpenState currentState;
    private String photoUrl;
    private Date lastUpdate;
    private String avgWaitingTime;
    private String avgPrice;
    private String avgCustomerNum;
    private String avgPlugNum;
    private String avgTableHeight;
    private String avgLightness;
    private String avgStayLong;
    private String avgOpenStyle;
    private Integer manyPlug;
    private Integer cheap;
    private Integer littlePeople;
    private Integer stayLong;
    private Integer light;
    private Integer stable;
    private Integer notLow;
    private Integer shortWaiting;

}
