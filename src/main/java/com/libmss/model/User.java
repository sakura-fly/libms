package com.libmss.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private  String uname;
    private String name;
    private String pwd;
    private Date ctime;
    private String phone;

    public User() {
    }

    public User(String uname, String name, String pwd, Date ctime, String phone) {
        this.uname = uname;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
