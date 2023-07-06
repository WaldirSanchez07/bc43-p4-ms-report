package com.nttdata.msreport.infrastructure.repository;

import com.nttdata.msreport.domain.model.Card;
import com.nttdata.msreport.domain.repository.CardRepository;
import com.nttdata.msreport.infrastructure.dao.repository.CardRepositoryRM;
import com.nttdata.msreport.infrastructure.mapper.CardMapper;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of CardRepository.
 */
@Service
@AllArgsConstructor
public class CardRepositoryImpl implements CardRepository {

  private final CardRepositoryRM repository;

  @Override
  public Maybe<Card> findById(String id) {
    return repository.customFindById(id)
            .map(CardMapper.INSTANCE::map);
  }

}
