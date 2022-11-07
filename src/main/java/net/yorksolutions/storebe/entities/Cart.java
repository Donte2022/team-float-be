package net.yorksolutions.storebe.entities;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String productName;

    private float price;

    private Integer quantity;

    public Cart() {
    }

    public Cart(String productName, float price, Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

}
