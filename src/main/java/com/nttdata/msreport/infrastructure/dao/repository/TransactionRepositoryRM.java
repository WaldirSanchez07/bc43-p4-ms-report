package com.nttdata.msreport.infrastructure.dao.repository;

import com.nttdata.msreport.domain.model.Transaction;
import com.nttdata.msreport.infrastructure.dao.entity.TransactionEntity;
import io.reactivex.rxjava3.core.Flowable;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepositoryRM extends ReactiveMongoRepository<TransactionEntity, String> {

  @Query("{$or: [{'accountId': ?0}, {'anotherAccountId': ?0}]}")
  Flowable<Transaction> findTransactions(String accountId);

  Flowable<Transaction> findByAccountIdAndTypeAndDateBetween(
          String accountId,
          String type,
          LocalDateTime startOfMonth,
          LocalDateTime startOfNextMonth
  );

  @Aggregation(value = {
    "{ $match: { cardId: ?0 } }",
    "{ $sort: { date: -1 } }",
    "{ $limit: ?1 }"
  })
  Flowable<Transaction> topTransactionsByCardId(String cardId, Integer limit);

}
