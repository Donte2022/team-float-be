package net.yorksolutions.storebe.dto;


import net.yorksolutions.storebe.entities.Account;

public class NewCartRequestDTO {


    public Integer productId;
    public String productName;

    public Integer quantity;

    public float price;
    public Account account;
}
