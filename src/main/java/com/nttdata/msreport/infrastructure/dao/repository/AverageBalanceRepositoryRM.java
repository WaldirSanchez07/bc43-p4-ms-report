package com.nttdata.msreport.infrastructure.dao.repository;

import com.nttdata.msreport.infrastructure.dao.entity.AverageBalanceEntity;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Data access.
 */
public interface AverageBalanceRepositoryRM extends ReactiveMongoRepository<AverageBalanceEntity, String> {

  @Query("{'clientId': ?0}")
  Flowable<AverageBalanceEntity> averageBalance(String clientId);

}
