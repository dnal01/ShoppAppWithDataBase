package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "type_id")
    private int typeId;
    @Column(name = "vendor_id")
    private int vendorId;
    @Column(name = "group_by_id")
    private int groupById;
    @Column(name = "is_weighed")
    private boolean isWeiged;
    @Column(name = "measure")
    private String measureUnit;

    public Product() {
    }

    public Product(int id, String description, String title, String category, int typeId, int vendorId, int groupById, boolean isWeiged, String measureUnit) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.category = category;
        this.typeId = typeId;
        this.vendorId = vendorId;
        this.groupById = groupById;
        this.isWeiged = isWeiged;
        this.measureUnit = measureUnit;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public int getVendorId() {
        return vendorId;
    }
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
    public int getGroupById() {
        return groupById;
    }
    public void setGroupById(int groupById) {
        this.groupById = groupById;
    }
    public boolean getIsWeiged() {
        return isWeiged;
    }
    public void setIsWeiged(boolean weiged) {
        isWeiged = weiged;
    }
    public String getMeasureUnit() {
        return measureUnit;
    }
    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }
}
