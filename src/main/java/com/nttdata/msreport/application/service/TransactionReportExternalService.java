package com.nttdata.msreport.application.service;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Flowable;

/**
 * Interface to define methods.
 */
public interface TransactionReportExternalService {

  Flowable<ObjectResponse> transactionsByProduct(String accountId);

  Flowable<ObjectResponse> commissionsByProduct(String accountId);

  Flowable<ObjectResponse> topTransactionsByCardId(String cardId, Integer limit);

}
