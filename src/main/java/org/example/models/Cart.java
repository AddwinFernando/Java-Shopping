package org.example.models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Cart {
    private int id;
    private int userid;

    private String title;

    private int count;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cart(int userid, int id, String title, int count, double price) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.count = count;
        this.price = price;
    }
}
