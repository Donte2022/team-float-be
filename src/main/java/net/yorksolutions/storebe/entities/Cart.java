package net.yorksolutions.storebe.entities;

import javax.persistence.*;


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cartId;

    private Integer orderId;

    private Integer productId;
    private String productName;

    private float price;

    private Integer quantity;

    @OneToOne
    Account account;


    public Cart() {
    }

    public Cart(Integer orderId, Integer productId, String productName, float price, Integer quantity, Account account) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.account = account;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Long getCartId() {
        return cartId;
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

    public void deleteById(Long cartId) {
    }
}
