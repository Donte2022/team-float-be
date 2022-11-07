package net.yorksolutions.storebe.entities;

import net.yorksolutions.storebe.dto.NewProductRequestDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String productName;
    private String displayName;
    private Float map;
    private Float price;
    private Date dateAvailable;
    private Float weight;
    private boolean discontinued;
    private Float cost;
    private String imageUrl;

//    public Set Category;


    public Product(NewProductRequestDTO newProduct) {
        this.productName = newProduct.productName;
        this.displayName = newProduct.displayName;
        this.map = newProduct.map;
        this.price = newProduct.price;
        this.dateAvailable = newProduct.dateAvailable;
        this.weight = newProduct.weight;
        this.discontinued = newProduct.discontinued;
        this.cost = newProduct.cost;
        this.imageUrl = newProduct.imageUrl;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Float getMap() {
        return map;
    }

    public void setMap(Float map) {
        this.map = map;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAll(Product product) {
        this.productName = product.productName;
        this.displayName = product.displayName;
        this.price = product.price;
        this.map = product.map;
        this.dateAvailable = product.dateAvailable;
        this.weight = product.weight;
        this.discontinued = product.discontinued;
        this.cost = product.cost;
        this.imageUrl = product.imageUrl;

    }
}
