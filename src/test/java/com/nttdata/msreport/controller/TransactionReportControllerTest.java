package com.nttdata.msreport.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.TransactionReportExternalService;
import com.nttdata.msreport.infrastructure.controller.TransactionReportController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.nttdata.msreport.util.TransactionTestUtil.generateTransactionResponse;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(TransactionReportControllerTest.class)
public class TransactionReportControllerTest {

  @InjectMocks
  TransactionReportController controller;

  @Mock
  private TransactionReportExternalService transactionService;


  @Test
  public void testTransactionsByProduct() {
    when(transactionService.transactionsByProduct(anyString())).thenReturn(generateTransactionResponse());

    WebTestClient client = WebTestClient.bindToController(controller).build();

    client.get().uri("/api/reports/transactions/list?accountId=1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .expectBodyList(ObjectResponse.class)
            .hasSize(2);
  }

  @Test
  public void testCommissionsByProduct() {
    when(transactionService.commissionsByProduct(anyString())).thenReturn(generateTransactionResponse());

    WebTestClient client = WebTestClient.bindToController(controller).build();

    client.get().uri("/api/reports/transactions/commissions?accountId=1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .expectBodyList(ObjectResponse.class)
            .hasSize(2);
  }

  @Test
  public void testTopTransactions() {
    when(transactionService.topTransactionsByCardId(anyString(), anyInt())).thenReturn(generateTransactionResponse());

    WebTestClient client = WebTestClient.bindToController(controller).build();

    client.get().uri("/api/reports/transactions/card?cardId=1&limit=10")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .expectBodyList(ObjectResponse.class)
            .hasSize(2);
  }

}
