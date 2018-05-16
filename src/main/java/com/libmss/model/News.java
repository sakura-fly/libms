package com.libmss.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class News {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id = -2233;
    private String title;
    private String content;
    // private Date op;
    // private Date ed;
    private Date time;
    private int uid = -2233;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid",insertable = false,updatable=false)
    private User user;
    public News() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NewsDao{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
