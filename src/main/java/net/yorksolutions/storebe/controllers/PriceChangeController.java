package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.PriceChangeDTO;
import net.yorksolutions.storebe.entities.PriceChange;
import net.yorksolutions.storebe.services.PriceChangeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricechangerequest")
@CrossOrigin
public class PriceChangeController {

    PriceChangeService service;

    public PriceChangeController(PriceChangeService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public PriceChange postprice (@RequestBody PriceChangeDTO price,@PathVariable Long id) {
        return service.PostPrice(price,id);
    }

    @PutMapping
    public void putprice (@RequestBody PriceChange price) {
        this.service.PutPrice(price);
    }

    @DeleteMapping("/{proid}/{id}")
    public void deleteprice (@PathVariable Long proid,@PathVariable Long id) {
        this.service.DeletePrice(proid,id);
    }

}
