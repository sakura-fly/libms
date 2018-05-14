package com.libmss.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id = -2233;
    private int uid = -2233;
    private int type = -2233;
    // @Column(insertable = false,updatable=false,nullable = false)
    private int bid = -2233;
    private Date op;
    private Date ed;
    private int days =  -2233;
    private int stat = -2233;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bid",insertable = false,updatable=false)
    private Book book;
    public Borrow() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
}
