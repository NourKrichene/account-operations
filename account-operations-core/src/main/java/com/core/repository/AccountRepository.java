package com.core.repository;

import com.core.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

}
