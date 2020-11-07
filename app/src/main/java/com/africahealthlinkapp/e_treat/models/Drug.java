package com.africahealthlinkapp.e_treat.models;

public class Drug {
    String name;
    String key;
    String price;

    public Drug() {
    }

    public Drug(String name, String key, String price) {
        this.name = name;
        this.key = key;
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
