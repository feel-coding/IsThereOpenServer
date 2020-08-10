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
@Table(name = "bar_patron")
public class BarPatron {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer seq;
    Integer barSeq;
    Integer userSeq;
}
