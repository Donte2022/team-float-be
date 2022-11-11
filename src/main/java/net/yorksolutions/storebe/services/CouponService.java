package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.NewCouponRequestDTO;
import net.yorksolutions.storebe.dto.UpdateCouponRequestDTO;
import net.yorksolutions.storebe.entities.Coupon;
import net.yorksolutions.storebe.repositories.CouponRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CouponService {
    CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon create(NewCouponRequestDTO requestDTO) {
        try {
            return this.couponRepository.save(

                    new Coupon(requestDTO.code, requestDTO.amount, requestDTO.percentage, requestDTO.startDate, requestDTO.endDate, requestDTO.useLimit));

        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    public Iterable<Coupon> getAll() {
        return this.couponRepository.findAll();
    }

    public void deleteById(Long id) {
        couponRepository.deleteById(id);
    }

    public Coupon update(UpdateCouponRequestDTO requestDTO) {
        Optional<Coupon> couponOpt = couponRepository.findById(requestDTO.id);
        if (couponOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Coupon coupon = couponOpt.get();
        coupon.setCode(requestDTO.code);
        coupon.setStartDate(requestDTO.startDate);
        coupon.setEndDate(requestDTO.endDate);
        coupon.setAmount(requestDTO.amount);
        coupon.setPercentage(requestDTO.percentage);
        coupon.setUseLimit(requestDTO.useLimit);
        return couponRepository.save(coupon);
    }

    public Coupon redeem(String code) {
        Optional<Coupon> couponOpt = couponRepository.findByCode(code);
        if (couponOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Coupon coupon = couponOpt.get();
        Long useLimit = coupon.getUseLimit();
        if (useLimit > 0) {
            coupon.setUseLimit(useLimit - 1);
            return couponRepository.save(coupon);
        }
        else
            throw new ResponseStatusException(HttpStatus.CONFLICT);

    }
}
