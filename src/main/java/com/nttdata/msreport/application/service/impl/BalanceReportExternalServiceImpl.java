package com.nttdata.msreport.application.service.impl;

import com.nttdata.msreport.application.dto.response.BalanceResponse;
import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.mapper.BalanceResponseMapper;
import com.nttdata.msreport.application.service.BalanceReportExternalService;
import com.nttdata.msreport.domain.service.BalanceService;
import com.nttdata.msreport.domain.service.CardService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BalanceReportExternalServiceImpl implements BalanceReportExternalService {

  private final BalanceService balanceService;
  private final CardService cardService;

  @Override
  public Maybe<ObjectResponse> balanceAvailableByProduct(String accountId) {
    return balanceService
            .findAvailableBalance(accountId)
            .map(balance -> {
              BalanceResponse obj = BalanceResponseMapper.INSTANCE.map(balance);
              return new ObjectResponse(200, null, obj);
            });
  }

  @Override
  public Flowable<ObjectResponse> averageBalancesByProduct(String clientId) {
    return balanceService
            .findAverageBalances(clientId)
            .map(obj -> new ObjectResponse(200, null, obj));
  }

  @Override
  public Maybe<ObjectResponse> mainAccountBalanceByDebitCard(String cardId) {
    return cardService
            .findById(cardId)
            .flatMap(card -> balanceService
                    .findAvailableBalance(card.getMainAccountId())
                    .map(obj -> new ObjectResponse(200, null, obj.getAmount())));
  }

}
