package com.learn.FarmConnect.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    private String pName;

    @Column(length = 3000)
    private String pDesc;

    private String pPhoto;

    private int pPrice;

    private int pDiscount;

    private int pQuantity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User farmer; // Add this line to establish a relationship with the User entity

    public Product() {
    }

    public Product(String pName, String pDesc, String pPhoto, int pPrice, int pDiscount, int pQuantity, Category category, User farmer) {
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pQuantity = pQuantity;
        this.category = category;
        this.farmer = farmer; // Initialize the farmer
    }

    // Getters and Setters
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(int pDiscount) {
        this.pDiscount = pDiscount;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getFarmer() { // Add getter for farmer
        return farmer;
    }

    public void setFarmer(User farmer) { // Add setter for farmer
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "Product{" + "pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pPhoto=" + pPhoto + ", pPrice=" + pPrice + ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity + '}';
    }

    // Calculate price after discount
    public int getPriceAfterApplyingDiscount() {
        int d = (int) ((this.getpDiscount() / 100.0) * this.getpPrice());
        return this.getpPrice() - d;
    }
}