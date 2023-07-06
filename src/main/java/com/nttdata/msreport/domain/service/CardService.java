package com.nttdata.msreport.domain.service;

import com.nttdata.msreport.domain.model.Card;
import io.reactivex.rxjava3.core.Maybe;

/**
 * Interface to define methods.
 */
public interface CardService {

  Maybe<Card> findById(String id);

}
