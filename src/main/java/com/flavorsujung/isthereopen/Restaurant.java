package com.flavorsujung.isthereopen;

public class Restaurant {
    Integer seq;
    String name;
    String address;
    String runtime;
    Double rate;
    Integer currentState;

    public Restaurant(Integer seq, String name, String address, String runtime, Double rate, Integer currentState) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }
}
