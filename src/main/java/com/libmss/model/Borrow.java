package com.libmss.model;

import java.util.Date;

public class Borrow {
    private int uid;
    private int type;
    private int bid;
    private Date op;
    private Date ed;
    private int stat;

    public Borrow() {
    }

    public Borrow(int uid, int type, int bid, Date op, Date ed, int stat) {
        this.uid = uid;
        this.type = type;
        this.bid = bid;
        this.op = op;
        this.ed = ed;
        this.stat = stat;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getOp() {
        return op;
    }

    public void setOp(Date op) {
        this.op = op;
    }

    public Date getEd() {
        return ed;
    }

    public void setEd(Date ed) {
        this.ed = ed;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "uid=" + uid +
                ", type=" + type +
                ", bid=" + bid +
                ", op=" + op +
                ", ed=" + ed +
                ", stat=" + stat +
                '}';
    }
}
