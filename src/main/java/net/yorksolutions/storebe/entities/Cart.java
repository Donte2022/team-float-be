package net.yorksolutions.storebe.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer productId;
    private String productName;

    private float price;

    private Integer quantity;



    @OneToOne
    Account owner;

//    @ManyToOne
//    Account owner;
//

//    Long owner;

//    @OneToMany
////    @JoinColumn(name="pastOrders")
//    public Set<Cart> pastOrders;

    public Cart() {
    }

    public Cart(Integer productId, String productName, float price, Integer quantity, Account owner) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.owner = owner;
    }

    public Account getOwner() {
        return owner;
    }

    public Integer getProductId() {
        return productId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void deleteById(Long id) {
    }
}
