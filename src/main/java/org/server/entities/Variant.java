package org.server.entities;

import jakarta.persistence.*;
import org.server.dto.ProductDtoRequest;

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
    private String barcode;
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
    public Variant(ProductDtoRequest request) {
        this.media = request.media();
        this.barcode = request.barcode();
        this.cost = request.cost();
        this.margin = request.margin();
        this.price = request.price();
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
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
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

    public void setProduct(Product product) {
        this.product = product;
    }
}
