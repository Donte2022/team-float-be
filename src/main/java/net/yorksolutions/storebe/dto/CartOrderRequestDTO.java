package net.yorksolutions.storebe.dto;

import net.yorksolutions.storebe.entities.Cart;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

public class CartOrderRequestDTO {

    public Integer accountId;

    public Date dateOrdered;

    public Integer productId;

    public String productName;

    public Integer quantity;

    public float price;

    @OneToMany
   public Set<Cart> cart;

}
