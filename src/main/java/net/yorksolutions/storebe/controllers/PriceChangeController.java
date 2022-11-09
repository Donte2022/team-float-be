package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.PriceChangeDTO;
import net.yorksolutions.storebe.entities.priceChange;
import net.yorksolutions.storebe.services.PriceChangeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price")
@CrossOrigin
public class PriceChangeController {

    PriceChangeService service;

    public PriceChangeController(PriceChangeService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public priceChange postprice (@RequestBody PriceChangeDTO price, @PathVariable Long id) {
        return service.postPrice(price,id);
    }

    @PutMapping
    public void putprice (@RequestBody priceChange price) {
        this.service.putPrice(price);
    }

    @DeleteMapping("/{proid}/{id}")
    public void deleteprice (@PathVariable Long proid,@PathVariable Long id) {
        this.service.deletePrice(proid,id);
    }

}
