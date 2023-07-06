package com.nttdata.msreport.domain.service.impl;

import com.nttdata.msreport.domain.model.Card;
import com.nttdata.msreport.domain.repository.CardRepository;
import com.nttdata.msreport.domain.service.CardService;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of CardService.
 */
@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

  private final CardRepository repository;

  @Override
  public Maybe<Card> findById(String id) {
    return repository.findById(id);
  }

}
