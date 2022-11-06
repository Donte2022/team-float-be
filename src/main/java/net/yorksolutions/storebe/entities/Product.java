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
    private float cost;
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
}
