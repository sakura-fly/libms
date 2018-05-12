package com.libmss.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class News {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String title;
    private String content;
    private Date op;
    private Date ed;
    private Date time;

    public News() {
    }

    public News(int id, String title, String content, Date op, Date ed, Date time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.op = op;
        this.ed = ed;
        this.time = time;
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
                ", op=" + op +
                ", ed=" + ed +
                '}';
    }
}
