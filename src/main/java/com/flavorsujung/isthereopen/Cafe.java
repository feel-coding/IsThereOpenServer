package com.flavorsujung.isthereopen;

public class Cafe {
    private Integer seq;
    private String name;
    private String address;
    private String runtime;
    private Double rate;
    private Integer currentState;

    public Cafe(Integer seq, String name, String address, String runtime, Double rate, Integer currentState) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runtime = runtime;
        this.rate = rate;
        this.currentState = currentState;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRuntime() {
        return runtime;
    }

    public Double getRate() {
        return rate;
    }

    public Integer getCurrentState() {
        return currentState;
    }
}
