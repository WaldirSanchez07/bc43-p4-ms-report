package com.nttdata.msreport.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.BalanceReportExternalService;
import com.nttdata.msreport.infrastructure.controller.BalanceReportController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.nttdata.msreport.util.BalanceTestUtil.generateAverageBalances;
import static com.nttdata.msreport.util.BalanceTestUtil.generateBalanceResponse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(BalanceReportControllerTest.class)
public class BalanceReportControllerTest {

  @InjectMocks
  BalanceReportController controller;

  @Mock
  private BalanceReportExternalService balanceService;

  @Test
  public void testBalanceAvailable() {
    when(balanceService.balanceAvailableByProduct(anyString())).thenReturn(generateBalanceResponse());

    WebTestClient client = WebTestClient.bindToController(controller).build();

    client.get().uri("/api/reports/balances/available?accountId=1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .returnResult(ObjectResponse.class)
            .consumeWith(o -> {
              Assertions.assertEquals(o.getResponseBody().blockFirst().getStatus(), 200);
            });
  }

  @Test
  public void testAverageBalances() {
    when(balanceService.averageBalancesByProduct(anyString())).thenReturn(generateAverageBalances());

    WebTestClient client = WebTestClient.bindToController(controller).build();

    client.get().uri("/api/reports/balances/average?accountId=1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .expectBodyList(ObjectResponse.class)
            .hasSize(2);
  }

  @Test
  public void testMainAccountBalance() {
    when(balanceService.mainAccountBalanceByDebitCard(anyString())).thenReturn(generateBalanceResponse());

    WebTestClient client = WebTestClient.bindToController(controller).build();

    client.get().uri("/api/reports/balances/main-account-balance?cardId=1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .returnResult(ObjectResponse.class)
            .consumeWith(o -> {
              Assertions.assertEquals(o.getResponseBody().blockFirst().getStatus(), 200);
            });
  }

}
