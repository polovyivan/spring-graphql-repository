package com.polovyi.ivan.repository;

import com.polovyi.ivan.entity.PurchaseTransactionEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseTransactionRepository extends
        CrudRepository<PurchaseTransactionEntity, String>, QuerydslPredicateExecutor<PurchaseTransactionEntity> {
}
