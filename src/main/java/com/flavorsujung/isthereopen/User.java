package com.flavorsujung.isthereopen;

public class User {
    private Integer seq;
    private String id;
    private String name;

    public User(Integer seq, String id, String name) {
        this.seq = seq;
        this.id = id;
        this.name = name;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
