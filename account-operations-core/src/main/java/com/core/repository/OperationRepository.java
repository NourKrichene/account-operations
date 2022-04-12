package com.core.repository;


import com.core.model.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();
}
