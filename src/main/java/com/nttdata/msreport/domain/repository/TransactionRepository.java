package com.nttdata.msreport.domain.repository;

import com.nttdata.msreport.domain.model.Transaction;
import io.reactivex.rxjava3.core.Flowable;

/**
 * Interface to define methods.
 */
public interface TransactionRepository {

  Flowable<Transaction> findTransactions(String accountId);

  Flowable<Transaction> findCommissionsCurrentMonth(String accountId);

  Flowable<Transaction> topTransactionsByCardId(String cardId, Integer limit);

}
