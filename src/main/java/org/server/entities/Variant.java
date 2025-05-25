package org.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "variants")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "media")
    private String media;
    @Column(name = "barcode")
    private long barcode;
    @Column(name = "leftovers")
    private int leftovers;
    @Column(name = "cost")
    private double cost;
    @Column(name = "margin")
    private double margin;
    @Column(name = "price")
    private double price;
    @Column(name = "order_limits")
    private int orderLimits;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
//    @Column(name = "product_id")
//    private int productId;

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
//        this.productId = productId;
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
    public long getBarcode() {
        return barcode;
    }
    public void setBarcode(long barcode) {
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
//    public int getProductId() {
//        return productId;
//    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
