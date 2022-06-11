package com.polovyi.ivan.repository;

import com.polovyi.ivan.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.graphql.data.GraphQlRepository;

import java.time.LocalDate;
import java.util.List;

@GraphQlRepository
public interface CustomerRepository extends
        CrudRepository<CustomerEntity, String>, QuerydslPredicateExecutor<CustomerEntity> {

}
