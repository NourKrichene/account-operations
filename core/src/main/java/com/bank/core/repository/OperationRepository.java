package com.bank.core.repository;


import com.bank.core.entity.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();

    List<Operation> findByLabel(String label);
}
