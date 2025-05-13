package org.example.entities;

public class Variant {
    private int id;
    private String media;
    private int barcode;
    private int leftovers;
    private double cost;
    private double margin;
    private double price;
    private int orderLimits;
    private int productId;

    public Variant() {
    }
    public Variant(int id, String media, int barcode, int leftovers, double cost, double margin, double price, int orderLimits, int productId) {
        this.id = id;
        this.media = media;
        this.barcode = barcode;
        this.leftovers = leftovers;
        this.cost = cost;
        this.margin = margin;
        this.price = price;
        this.orderLimits = orderLimits;
        this.productId = productId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMedia() {
        return media;
    }
    public void setMedia(String media) {
        this.media = media;
    }
    public int getBarcode() {
        return barcode;
    }
    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
    public int getLeftovers() {
        return leftovers;
    }
    public void setLeftovers(int leftovers) {
        this.leftovers = leftovers;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getMargin() {
        return margin;
    }
    public void setMargin(double margin) {
        this.margin = margin;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getOrderLimits() {
        return orderLimits;
    }
    public void setOrderLimits(int orderLimits) {
        this.orderLimits = orderLimits;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
}
