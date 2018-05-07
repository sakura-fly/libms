package com.libmss.model;

public class Analyze {
    private String type;
    private long num = -2233;

    public Analyze(String type, long num) {
        this.type = type;
        this.num = num;
    }

    public Analyze() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
