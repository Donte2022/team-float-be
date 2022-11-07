package net.yorksolutions.storebe.repositories;


public interface AccountRepository{

import net.yorksolutions.storebe.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account>findByUsername(String username);
    Optional<Account>findByUsernameAndPassword(String username, String password);

}
