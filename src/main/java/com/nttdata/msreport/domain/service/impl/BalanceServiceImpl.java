package com.nttdata.msreport.domain.service.impl;

import com.nttdata.msreport.domain.model.AverageBalance;
import com.nttdata.msreport.domain.model.Balance;
import com.nttdata.msreport.domain.repository.BalanceRepository;
import com.nttdata.msreport.domain.service.BalanceService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of BalanceService.
 */
@Service
@AllArgsConstructor
public class BalanceServiceImpl implements BalanceService {

  private final BalanceRepository balanceRepository;

  @Override
  public Flowable<AverageBalance> findAverageBalances(String accountId) {
    return balanceRepository.findAverageBalances(accountId);
  }

  @Override
  public Maybe<Balance> findAvailableBalance(String accountId) {
    return balanceRepository.findAvailableBalance(accountId);
  }

}
