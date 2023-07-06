package com.nttdata.msreport.domain.service.impl;

import com.nttdata.msreport.domain.model.Transaction;
import com.nttdata.msreport.domain.repository.TransactionRepository;
import com.nttdata.msreport.domain.service.TransactionService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of TransactionService.
 */
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  @Override
  public Flowable<Transaction> findTransactions(String accountId) {
    return transactionRepository.findTransactions(accountId);
  }

  @Override
  public Flowable<Transaction> findCommissionsCurrentMonth(String accountId) {
    return transactionRepository.findCommissionsCurrentMonth(accountId);
  }

  @Override
  public Flowable<Transaction> topTransactionsByCardId(String cardId, Integer limit) {
    return transactionRepository.topTransactionsByCardId(cardId, limit);
  }

}
