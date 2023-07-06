package com.nttdata.msreport.infrastructure.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.TransactionReportExternalService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Rest Full
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/reports/transactions")
public class TransactionReportController {

  private final TransactionReportExternalService reportService;

  @GetMapping(
          value = "/list",
          params = "accountId",
          produces = MediaType.TEXT_EVENT_STREAM_VALUE
  )
  public Flowable<ObjectResponse> transactionsByProduct(
          @RequestParam String accountId
  ) {
    return reportService.transactionsByProduct(accountId);
  }

  @GetMapping(
          value = "/commissions",
          params = "accountId",
          produces = MediaType.TEXT_EVENT_STREAM_VALUE
  )
  public Flowable<ObjectResponse> commissionsByProduct(
          @RequestParam String accountId
  ) {
    return reportService.commissionsByProduct(accountId);
  }

  @GetMapping(
          value = "/card",
          produces = MediaType.TEXT_EVENT_STREAM_VALUE
  )
  public Flowable<ObjectResponse> topTransactions(
          @RequestParam("cardId") String cardId,
          @RequestParam("limit") Integer limit
  ) {
    return reportService.topTransactionsByCardId(cardId, limit);
  }

}
