package com.isolutions4u.onlineshopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    @NotBlank(message = "Please Enter the Product Name")
    private String name;

    @Column(name = "brand")
    @NotBlank(message = "Please Enter the Brand Name")
    private String brand;

    @Column(name = "description")
    @JsonIgnore
    @NotBlank(message = "Please Enter the Product Description")
    private String description;

    @Column(name = "unit_price")
    @Min(value = 1, message = "Unit Price atleast one (1)")
    private double unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "category_id")
    @JsonIgnore
    private int categoryId;

    @Column(name = "supplier_id")
    @JsonIgnore
    private int supplierId;

    @Column(name = "purchases")
    private int purchases;

    @Column(name = "views")
    private int views;

    @Transient
    private MultipartFile file;

    // default constructor
    public Product() {
        this.code = "PRO" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
                + description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
                + ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
                + views + "]";
    }

}
