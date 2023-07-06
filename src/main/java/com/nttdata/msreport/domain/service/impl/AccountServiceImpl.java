package com.nttdata.msreport.domain.service.impl;

import com.nttdata.msreport.domain.model.Account;
import com.nttdata.msreport.domain.model.AccountSummary;
import com.nttdata.msreport.domain.repository.AccountRepository;
import com.nttdata.msreport.domain.service.AccountService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of AccountService.
 */
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;

  @Override
  public Flowable<Account> findAllAccounts(String clientId) {
    return repository.findAllAccounts(clientId);
  }

  @Override
  public Flowable<AccountSummary> summaryAccounts(String clientId) {
    return repository.summaryAccounts(clientId);
  }

}
