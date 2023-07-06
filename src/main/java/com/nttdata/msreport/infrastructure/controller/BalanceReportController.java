package com.nttdata.msreport.infrastructure.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.BalanceReportExternalService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Rest Full.
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/reports/balances")
public class BalanceReportController {

  private final BalanceReportExternalService reportService;

  @GetMapping(
          value = "/available",
          params = "accountId",
          produces = MediaType.TEXT_EVENT_STREAM_VALUE
  )
  public Maybe<ObjectResponse> balanceAvailable(@RequestParam String accountId) {
    return reportService.balanceAvailableByProduct(accountId);
  }

  @GetMapping(
          value = "/average",
          params = "accountId",
          produces = MediaType.TEXT_EVENT_STREAM_VALUE
  )
  public Flowable<ObjectResponse> averageBalances(@RequestParam String accountId) {
    return reportService.averageBalancesByProduct(accountId);
  }

  @GetMapping(
          value = "/main-account-balance",
          produces = MediaType.TEXT_EVENT_STREAM_VALUE
  )
  public Maybe<ObjectResponse> mainAccountBalance(@RequestParam("cardId") String cardId) {
    return reportService.mainAccountBalanceByDebitCard(cardId);
  }

}
