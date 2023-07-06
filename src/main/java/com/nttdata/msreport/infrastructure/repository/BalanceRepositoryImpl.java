package com.nttdata.msreport.infrastructure.repository;

import com.nttdata.msreport.domain.model.AverageBalance;
import com.nttdata.msreport.domain.model.Balance;
import com.nttdata.msreport.domain.repository.BalanceRepository;
import com.nttdata.msreport.infrastructure.dao.repository.BalanceRepositoryRM;
import com.nttdata.msreport.infrastructure.mapper.AverageBalanceMapper;
import com.nttdata.msreport.infrastructure.mapper.BalanceMapper;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import java.time.LocalDateTime;
import java.time.YearMonth;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Implementation of BalanceRepository.
 */
@Repository
@AllArgsConstructor
public class BalanceRepositoryImpl implements BalanceRepository {

  private final BalanceRepositoryRM balanceRepository;

  @Override
  public Flowable<AverageBalance> findAverageBalances(String accountId) {
    var currentYearMonth = YearMonth.now();
    LocalDateTime startOfMonth = currentYearMonth.atDay(1).atStartOfDay();

    var nextYearMonth = currentYearMonth.plusMonths(1);
    LocalDateTime startOfNextMonth = nextYearMonth.atDay(1).atStartOfDay();

    return balanceRepository
            .averageBalances(accountId, startOfMonth, startOfNextMonth)
            .map(AverageBalanceMapper.INSTANCE::map);
  }

  @Override
  public Maybe<Balance> findAvailableBalance(String accountId) {
    return balanceRepository
            .findFirstByAccountIdOrderByDateDesc(accountId)
            .map(BalanceMapper.INSTANCE::map)
            .defaultIfEmpty(Balance.builder().amount((double) 0).build())
            .toMaybe();
  }

}
