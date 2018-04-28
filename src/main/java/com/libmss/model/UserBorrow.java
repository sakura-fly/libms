package com.libmss.model;

import java.util.Date;

public class UserBorrow {
    private String bookName;
    private Date bTime;
    private Date rTime;
    private  Date rrTime;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getbTime() {
        return bTime;
    }

    public void setbTime(Date bTime) {
        this.bTime = bTime;
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public Date getRrTime() {
        return rrTime;
    }

    public void setRrTime(Date rrTime) {
        this.rrTime = rrTime;
    }

    public UserBorrow(String bookName, Date bTime, Date rTime, Date rrTime) {

        this.bookName = bookName;
        this.bTime = bTime;
        this.rTime = rTime;
        this.rrTime = rrTime;
    }

    public UserBorrow() {

    }
}
