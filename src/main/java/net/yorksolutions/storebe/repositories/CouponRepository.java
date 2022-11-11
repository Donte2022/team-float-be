package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {
}
