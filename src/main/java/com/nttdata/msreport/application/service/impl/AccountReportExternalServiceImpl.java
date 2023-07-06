package com.nttdata.msreport.application.service.impl;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.AccountReportExternalService;
import com.nttdata.msreport.domain.service.AccountService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of AccountReportExternalService.
 */
@Service
@AllArgsConstructor
public class AccountReportExternalServiceImpl implements AccountReportExternalService {

  private final AccountService accountService;

  @Override
  public Flowable<ObjectResponse> summaryAccounts(String clientId) {
    return accountService
            .summaryAccounts(clientId)
            .map(obj -> new ObjectResponse(200, null, obj));
  }

}
