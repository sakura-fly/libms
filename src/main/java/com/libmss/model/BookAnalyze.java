package com.libmss.model;

public class BookAnalyze {
    private String type;
    private long num;

    public BookAnalyze(String type, long num) {
        this.type = type;
        this.num = num;
    }

    public BookAnalyze() {
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
