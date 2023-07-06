package com.nttdata.msreport.infrastructure.dao.repository;

import com.nttdata.msreport.infrastructure.dao.entity.CardEntity;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CardRepositoryRM extends ReactiveMongoRepository<CardEntity, String> {

  @Query(value = "{ _id: ?0 }")
  Maybe<CardEntity> customFindById(String id);

}
