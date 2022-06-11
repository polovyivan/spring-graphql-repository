package com.polovyi.ivan.configuration;

import com.polovyi.ivan.projection.PurchaseTransactionProjection;
import com.polovyi.ivan.repository.PurchaseTransactionRepository;
import graphql.scalars.ExtendedScalars;
import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.data.query.QuerydslDataFetcher;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
@RequiredArgsConstructor
public class GraphQLConfig {

    private final PurchaseTransactionRepository purchaseTransactionRepository;

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {

        return wiringBuilder -> wiringBuilder
                .scalar(ExtendedScalars.Date)
                .type("Query", builder -> builder.dataFetcher("findPurchaseTransactionById",
                        createSingleDataFetcherForFindPurchaseTransactionById()))
                .type("Query", builder -> builder.dataFetcher("findAllPurchaseTransactions",
                        createManyDataFetcherForFindAllPurchaseTransactions()))
                .build();
    }

    // For single result queries
    private DataFetcher<PurchaseTransactionProjection> createSingleDataFetcherForFindPurchaseTransactionById() {
        return QuerydslDataFetcher.builder(purchaseTransactionRepository).projectAs(PurchaseTransactionProjection.class)
                .single();
    }

    // For multi-result queries
    private DataFetcher<Iterable<PurchaseTransactionProjection>> createManyDataFetcherForFindAllPurchaseTransactions() {
        return QuerydslDataFetcher.builder(purchaseTransactionRepository).projectAs(PurchaseTransactionProjection.class)
                .many();
    }

}
