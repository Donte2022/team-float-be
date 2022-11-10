package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.NewCouponRequestDTO;
import net.yorksolutions.storebe.dto.UpdateCouponRequestDTO;
import net.yorksolutions.storebe.entities.Coupon;
import net.yorksolutions.storebe.services.CouponService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupon")
@CrossOrigin
public class CouponController {
    CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public Coupon create(@RequestBody NewCouponRequestDTO requestDTO) {
        return couponService.create(requestDTO);
    }

    @GetMapping
    public Iterable<Coupon> getAll() {
        return couponService.getAll();
    }

    @DeleteMapping("/{couponId}")
    public void deleteById(@PathVariable Long couponId) {
        couponService.deleteById(couponId);
    }

    @PutMapping
    public Coupon update(@RequestBody UpdateCouponRequestDTO requestDTO) {
        return couponService.update(requestDTO);
    }

    @PutMapping("/redeem/{couponId}")
    public Coupon redeem(@PathVariable Long couponId) {
        return couponService.redeem(couponId);
    }
}
