package net.yorksolutions.storebe.dto;

import java.util.Date;

public class UpdateCouponRequestDTO {
    public Long id;
    public String code;
    public Double amount;
    public Float percentage;
    public Date startDate;
    public Date endDate;
    public Long useLimit;
}
