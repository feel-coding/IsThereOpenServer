package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
public class RestaurantOpenReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;
    private Long userSeq;
    private Long restaurantSeq;
    @Convert(converter = OpenStateConverter.class)
    private OpenState openState; //0 close, 1 break time, 2 open, 3 미확인
    @Basic(optional = false)
    @Column(name = "createdAt", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


}
