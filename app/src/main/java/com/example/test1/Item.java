package com.example.test1;

public class Item  {
    // public static int ID=0;
    //private int id;
    String name;
    String price;

    public Item(String name, String price) {
        //this.id=ID;
        this.name = name;
        this.price = price;
        //Item.ID++;
    }
    public Item(){

    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}