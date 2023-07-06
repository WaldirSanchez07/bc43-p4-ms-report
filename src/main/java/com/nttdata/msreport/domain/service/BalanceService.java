package com.nttdata.msreport.domain.service;

import com.nttdata.msreport.domain.model.AverageBalance;
import com.nttdata.msreport.domain.model.Balance;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

/**
 * Interface to define methods.
 */
public interface BalanceService {

  Flowable<AverageBalance> findAverageBalances(String accountId);

  Maybe<Balance> findAvailableBalance(String accountId);

}
