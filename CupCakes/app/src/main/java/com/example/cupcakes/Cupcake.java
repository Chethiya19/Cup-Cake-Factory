package com.example.cupcakes;

public class Cupcake {

    private int CCID;
    private String name;
    private double price;
    private byte[] image;

    public int getCCID() {
        return CCID;
    }

    public void setCCID(int CCID) {
        this.CCID = CCID;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
