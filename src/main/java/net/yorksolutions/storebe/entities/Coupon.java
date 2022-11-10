package net.yorksolutions.storebe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Coupon {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true)
    String code;

    Double amount;

    Float percentage;

    Date startDate;
    Date endDate;
    Long useLimit;

    public Coupon() {
    }

    public Coupon(String code, Double amount, Float percentage, Date startDate, Date endDate, Long useLimit) {
        this.code = code;
        this.amount = amount;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.useLimit = useLimit;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
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

    public Long getUseLimit() {
        return useLimit;
    }

    public void setUseLimit(Long useLimit) {
        this.useLimit = useLimit;
    }
}
