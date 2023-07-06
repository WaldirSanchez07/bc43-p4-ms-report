package com.nttdata.msreport.infrastructure.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.AccountReportExternalService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Rest Full AccountReportController.
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/reports/accounts")
public class AccountReportController {

  private final AccountReportExternalService accountService;

  @GetMapping(value = "/summary", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> summaryAccounts(@RequestParam("clientId") String clientId) {
    return accountService.summaryAccounts(clientId);
  }

}
