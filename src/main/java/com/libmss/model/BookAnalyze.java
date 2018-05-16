package com.libmss.model;

public class BookAnalyze {
    private String type;
    private long num = -2233;
    private String tname;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

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
