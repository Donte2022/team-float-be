package net.yorksolutions.storebe.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PriceChange {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;

    Boolean sale;

   Long newPrice;

   Date startDate;

   Date endDate;

   Long couponLeft;


    public PriceChange() {
    }

    public PriceChange(Boolean sale, Long newPrice, Date startDate, Date endDate, Long couponLeft) {
        this.sale = sale;
        this.newPrice = newPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.couponLeft = couponLeft;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Long getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Long newPrice) {
        this.newPrice = newPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getCouponLeft() {
        return couponLeft;
    }

    public void setCouponLeft(Long couponLeft) {
        this.couponLeft = couponLeft;
    }


}
