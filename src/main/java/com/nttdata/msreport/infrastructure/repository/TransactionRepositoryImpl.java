package com.nttdata.msreport.infrastructure.repository;

import com.nttdata.msreport.domain.model.Transaction;
import com.nttdata.msreport.domain.repository.TransactionRepository;
import com.nttdata.msreport.infrastructure.dao.repository.TransactionRepositoryRM;
import io.reactivex.rxjava3.core.Flowable;
import java.time.LocalDateTime;
import java.time.YearMonth;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Implementation of TransactionRepository.
 */
@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

  private final TransactionRepositoryRM repository;

  @Override
  public Flowable<Transaction> findTransactions(String accountId) {
    return repository.findTransactions(accountId);
  }

  @Override
  public Flowable<Transaction> findCommissionsCurrentMonth(String accountId) {
    var currentYearMonth = YearMonth.now();
    LocalDateTime startOfMonth = currentYearMonth.atDay(1).atStartOfDay();

    var nextYearMonth = currentYearMonth.plusMonths(1);
    LocalDateTime startOfNextMonth = nextYearMonth.atDay(1).atStartOfDay();

    return repository.findByAccountIdAndTypeAndDateBetween(
            accountId,
            "Comision",
            startOfMonth,
            startOfNextMonth
    );
  }

  @Override
  public Flowable<Transaction> topTransactionsByCardId(String cardId, Integer limit) {
    return repository.topTransactionsByCardId(cardId, limit);
  }

}
