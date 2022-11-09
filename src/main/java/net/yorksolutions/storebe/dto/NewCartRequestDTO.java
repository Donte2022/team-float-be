package net.yorksolutions.storebe.dto;


import net.yorksolutions.storebe.entities.Account;
import net.yorksolutions.storebe.entities.Orders;

import java.util.List;

public class NewCartRequestDTO {


    public Integer orderId;

    public Integer productId;
    public String productName;

    public Integer quantity;

    public float price;
    public Account account;


}
