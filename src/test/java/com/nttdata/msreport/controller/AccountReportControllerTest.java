package com.nttdata.msreport.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.AccountReportExternalService;
import com.nttdata.msreport.infrastructure.controller.AccountReportController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.nttdata.msreport.util.SummaryAccountTestUtil.generateList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(AccountReportControllerTest.class)
public class AccountReportControllerTest {

  @InjectMocks
  AccountReportController controller;

  @Mock
  private AccountReportExternalService accountService;

  @Test
  public void testSummaryAccounts() {
    when(accountService.summaryAccounts(anyString())).thenReturn(generateList());

    WebTestClient client = WebTestClient.bindToController(controller).build();

    client.get().uri("/api/reports/accounts/summary?clientId=1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .expectBodyList(ObjectResponse.class)
            .hasSize(2);
  }

}
