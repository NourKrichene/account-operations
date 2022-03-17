package com.bank.corebanking.repository;

import com.bank.corebanking.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

}
