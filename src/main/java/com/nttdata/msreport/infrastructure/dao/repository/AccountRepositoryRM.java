package com.nttdata.msreport.infrastructure.dao.repository;

import com.nttdata.msreport.domain.model.AccountSummary;
import com.nttdata.msreport.infrastructure.dao.entity.AccountEntity;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepositoryRM extends ReactiveMongoRepository<AccountEntity, String> {

  @Query("{ 'clientId': ?0 }")
  Flowable<AccountEntity> findAllAccounts(String clientId);

  @Aggregation(value = {
    "{ $match: { clientId: ?0 } }",
    "{ $lookup: { from: 'passive_products', localField: 'passiveProductId', foreignField: '_id', as: 'passiveProduct' } }",
    "{ $unwind: { path: '$passiveProduct', preserveNullAndEmptyArrays: true } }",
    "{ $lookup: { from: 'active_products', localField: 'activeProductId', foreignField: '_id', as: 'activeProduct' } }",
    "{ $unwind: { path: '$activeProduct', preserveNullAndEmptyArrays: true } }",
    "{ $lookup: { from: 'balances', localField: '_id', foreignField: 'accountId', as: 'balance', pipeline: [ { $sort: { date: -1 } }, { $limit: 1 } ] } }",
    "{ $unwind: { path: '$balance', preserveNullAndEmptyArrays: true } }",
    "{ $set: { balance: { $cond: [ { $ifNull: ['$balance', false] }, '$balance.amount', 0 ] }, productType: { $cond: [ { $ifNull: ['$passiveProduct', false] }, '$passiveProduct.name', '$activeProduct.name' ] } } }",
    "{ $project: { _id: 1, accountNumber: 1, productType: 1, balance: 1, date: 1 } }"
  })
  Flowable<AccountSummary> summaryAccounts(String clientId);

}
