package com.libmss.model;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id = -2233;
    private String name;
    private double price = -2233;
    private String author;
    private String publisher;
    private String edition;
    private int num = -2233;

    public Book() {
    }

    public Book(int id, String name, double price, String author, String publisher, String edition, int num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", edition='" + edition + '\'' +
                '}';
    }
}
