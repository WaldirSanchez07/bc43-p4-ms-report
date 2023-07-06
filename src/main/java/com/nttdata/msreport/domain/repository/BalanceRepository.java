package com.nttdata.msreport.domain.repository;

import com.nttdata.msreport.domain.model.AverageBalance;
import com.nttdata.msreport.domain.model.Balance;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface BalanceRepository {

  Flowable<AverageBalance> findAverageBalances(String accountId);

  Maybe<Balance> findAvailableBalance(String accountId);

}
