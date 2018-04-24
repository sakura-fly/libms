package com.libmss.model;

import java.util.Date;

public class User {
    private  String uname;
    private String pwd;
    private Date ctime;
    private String phone;

    public User() {
    }

    public User(String uname, String pwd, Date ctime, String phone) {
        this.uname = uname;
        this.pwd = pwd;
        this.ctime = ctime;
        this.phone = phone;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", ctime=" + ctime +
                ", phone='" + phone + '\'' +
                '}';
    }
}
