package net.yorksolutions.storebe.dto;

import java.util.Date;

public class NewCouponRequestDTO {
    public String code;
    public Double amount;
    public Float percentage;
    public Date startDate;
    public Date endDate;
    public Long useLimit;
}
