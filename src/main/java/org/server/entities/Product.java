package org.server.entities;

import jakarta.persistence.*;
import org.server.dto.ProductDtoRequest;

import java.util.List;

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

    @OneToMany(mappedBy = "product")
    private List<Variant> variants;

    public Product() {
    }

    public Product(ProductDtoRequest request) {
        this.description = request.description();
        this.title = request.title();
        this.category = request.category();
        this.typeId = request.typeId();
        this.vendorId = request.vendorId();
        this.groupById = request.groupById();
        this.isWeiged = request.isWeiged();
        this.measureUnit = request.measureUnit();
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
    @Override
    public String toString() {
        return  "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", measureUnit='" + measureUnit + '\'' +
                '}';
    }
}
