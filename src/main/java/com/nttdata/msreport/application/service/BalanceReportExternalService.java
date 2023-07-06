package com.nttdata.msreport.application.service;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

/**
 * Interface to define methods.
 */
public interface BalanceReportExternalService {

  Maybe<ObjectResponse> balanceAvailableByProduct(String accountId);

  Flowable<ObjectResponse> averageBalancesByProduct(String clientId);

  Maybe<ObjectResponse> mainAccountBalanceByDebitCard(String cardId);

}
