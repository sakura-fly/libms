package com.libmss.model;

public class Book {
    private String name;
    private double price;
    private String author;
    private String publisher;
    private String edition;
    private int num = -2233;

    public Book() {
    }

    public Book(String name, double price, String author, String publisher, String edition, int num) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.num = num;
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
