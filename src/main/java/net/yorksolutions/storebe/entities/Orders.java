package net.yorksolutions.storebe.entities;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer accountId;
    private Date dateOrdered;

    private Integer productId;

    private String productName;

    private Integer quantity;

    private float price;

//    @ManyToOne
//    public Set<>;

    public Orders() {
    }


    public Orders(Integer accountId, Date dateOrdered, Integer productId, String productName, Integer quantity, float price) {

        this.accountId = accountId;
        this.dateOrdered = dateOrdered;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getAccountId() {
        return accountId;
    }


    public Long getId() {
        return id;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
