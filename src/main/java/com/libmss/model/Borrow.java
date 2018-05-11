package com.libmss.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Borrow {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


    private int uid = -2233;
    private int type = -2233;
    private int bid = -2233;
    private Date op;
    private Date ed;
    private int days =  -2233;
    private int stat = -2233;

    public Borrow() {
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Borrow(int uid, int type, int bid, Date op, Date ed, int days, int stat) {

        this.uid = uid;
        this.type = type;
        this.bid = bid;
        this.op = op;
        this.ed = ed;
        this.days = days;
        this.stat = stat;
    }

    public Borrow(int uid, int type, int bid, Date op, Date ed, int stat) {
        this.uid = uid;
        this.type = type;
        this.bid = bid;
        this.op = op;
        this.ed = ed;
        this.stat = stat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Borrow(int id, int uid, int type, int bid, Date op, Date ed, int stat) {

        this.id = id;
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
        return "BorrowDao{" +
                "uid=" + uid +
                ", type=" + type +
                ", bid=" + bid +
                ", op=" + op +
                ", ed=" + ed +
                ", stat=" + stat +
                '}';
    }
}
