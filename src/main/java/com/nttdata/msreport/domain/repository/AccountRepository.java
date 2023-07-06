package com.nttdata.msreport.domain.repository;

import com.nttdata.msreport.domain.model.Account;
import com.nttdata.msreport.domain.model.AccountSummary;
import io.reactivex.rxjava3.core.Flowable;

/**
 * Interface to define methods.
 */
public interface AccountRepository {

  Flowable<Account> findAllAccounts(String clientId);

  Flowable<AccountSummary> summaryAccounts(String clientId);

}
