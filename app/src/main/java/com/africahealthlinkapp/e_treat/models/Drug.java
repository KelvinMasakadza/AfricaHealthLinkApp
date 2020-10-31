package com.africahealthlinkapp.e_treat.models;

public class Drug {
    String name;
    String dose;
    int price;

    public Drug(String name, String dose, int price) {
        this.name = name;
        this.dose = dose;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
