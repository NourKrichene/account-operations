package com.mybank.repository;

import java.util.List;

import com.mybank.entity.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();

    List<Operation> findByLabel(String label);
}
