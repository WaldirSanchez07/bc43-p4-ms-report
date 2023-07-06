package com.nttdata.msreport.application.service.impl;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.dto.response.TransactionResponse;
import com.nttdata.msreport.application.mapper.TransactionResponseMapper;
import com.nttdata.msreport.application.service.TransactionReportExternalService;
import com.nttdata.msreport.domain.service.TransactionService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionReportExternalServiceImpl implements TransactionReportExternalService {

  private final TransactionService transactionService;

  @Override
  public Flowable<ObjectResponse> transactionsByProduct(String accountId) {
    return transactionService
            .findTransactions(accountId)
            .map(t -> {
              Double amount = (t.getType().equals("Deposito") || t.getAnotherAccountId() == null) ? t.getAmount() : t.getAmount() * -1;
              t.setAmount(amount);
              TransactionResponse obj = TransactionResponseMapper.INSTANCE.map(t);
              return new ObjectResponse(200, null, obj);
            });
  }

  @Override
  public Flowable<ObjectResponse> commissionsByProduct(String accountId) {
    return transactionService
            .findCommissionsCurrentMonth(accountId)
            .map(t -> {
              t.setType(null);
              TransactionResponse obj = TransactionResponseMapper.INSTANCE.map(t);
              return new ObjectResponse(200, null, obj);
            });
  }

  @Override
  public Flowable<ObjectResponse> topTransactionsByCardId(String cardId, Integer limit) {
    return transactionService
            .topTransactionsByCardId(cardId, limit)
            .map(obj -> new ObjectResponse(200, null, obj));
  }


}
