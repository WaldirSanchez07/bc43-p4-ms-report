package com.nttdata.msreport.infrastructure.repository;

import com.nttdata.msreport.domain.model.Account;
import com.nttdata.msreport.domain.model.AccountSummary;
import com.nttdata.msreport.domain.repository.AccountRepository;
import com.nttdata.msreport.infrastructure.dao.repository.AccountRepositoryRM;
import com.nttdata.msreport.infrastructure.mapper.AccountMapper;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Implementation of AccountRepository.
 */
@Repository
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

  private final AccountRepositoryRM repository;

  @Override
  public Flowable<Account> findAllAccounts(String clientId) {
    return repository.findAllAccounts(clientId)
            .map(AccountMapper.INSTANCE::map);
  }

  @Override
  public Flowable<AccountSummary> summaryAccounts(String clientId) {
    return repository.summaryAccounts(clientId);
  }

}
