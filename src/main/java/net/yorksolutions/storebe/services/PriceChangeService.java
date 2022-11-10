package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.PriceChangeDTO;
import net.yorksolutions.storebe.entities.priceChange;
import net.yorksolutions.storebe.entities.Product;
import net.yorksolutions.storebe.repositories.PriceChangeRepository;
import net.yorksolutions.storebe.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PriceChangeService {

    PriceChangeRepository priceChangeRepository;
    ProductRepository productRepository;

    public PriceChangeService(PriceChangeRepository priceChangeRepository, ProductRepository productRepository) {
        this.priceChangeRepository = priceChangeRepository;
        this.productRepository = productRepository;
    }

    public priceChange postPrice (PriceChangeDTO dto, Long id) {
        Optional<Product> op = productRepository.findById(id);
        if (op.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
        priceChange price = new priceChange(
                dto.sale,
                dto.newPrice,
                dto.startDate,
                dto.endDate,
                dto.couponLeft);
            op.get().priceChange.add(price);
            priceChangeRepository.save(price);
            return price;
                }
    }

    public void putPrice(priceChange priceChange) {
      Optional<net.yorksolutions.storebe.entities.priceChange> op =  priceChangeRepository.findById(priceChange.id);
      if (op.isEmpty()){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      else {
          priceChangeRepository.save(priceChange);
      }
    }

    public void deletePrice(Long proid, Long id) {
        Optional<priceChange> op = priceChangeRepository.findById(id);
        Optional<Product> op2 = productRepository.findById(proid);
        if (op.isEmpty() || op2.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            op2.get().priceChange.remove(op.get());
            priceChangeRepository.deleteById(id);
        }
    }
}
