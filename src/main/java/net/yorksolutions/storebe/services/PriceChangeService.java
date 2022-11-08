package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.PriceChangeDTO;
import net.yorksolutions.storebe.entities.PriceChange;
import net.yorksolutions.storebe.entities.Product;
import net.yorksolutions.storebe.repositories.PriceChangeRepository;
import net.yorksolutions.storebe.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PriceChangeService {

    PriceChangeRepository repository;
    ProductRepository prorepo;

    public PriceChangeService(PriceChangeRepository repository, ProductRepository prorepo) {
        this.repository = repository;
        this.prorepo = prorepo;
    }

    public PriceChange PostPrice (PriceChangeDTO dto,Long id) {
        Optional<Product> op = prorepo.findById(id);
        if (op.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
        PriceChange price = new PriceChange(
                dto.sale,
                dto.newPrice,
                dto.startDate,
                dto.endDate,
                dto.couponLeft);
            op.get().PriceChange.add(price);
            repository.save(price);
            return price;
                }
    }

    public void PutPrice (PriceChangeDTO dto,Long oldid, Long id,Long proid) {
        System.out.println(id);
        Optional<PriceChange> optional = repository.findById(id);
        Optional<Product> optional3 = prorepo.findById(oldid);
        Optional<Product> optional2 = prorepo.findById(proid);

        if (optional.isEmpty() || optional3.isEmpty()){
            System.out.println( 1 + id);
            System.out.println(3 + oldid);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else {

            if (optional2.isPresent()) {
                optional3.get().PriceChange.remove(optional.get());
                optional2.get().PriceChange.add(optional.get());
            }

                PriceChange priceChange = optional.get();
                priceChange.setNewPrice(dto.newPrice);
                priceChange.setSale(dto.sale);
                priceChange.setStartDate(dto.startDate);
                priceChange.setEndDate(dto.endDate);
                priceChange.setCouponLeft(dto.couponLeft);
                repository.save(priceChange);
        }
    }

    public void DeletePrice (Long proid,Long id) {
        Optional<PriceChange> op = repository.findById(id);
        Optional<Product> op2 = prorepo.findById(proid);
        if (op.isEmpty() || op2.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            op2.get().PriceChange.remove(op.get());
            repository.deleteById(id);
        }
    }
}
