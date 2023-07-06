package com.nttdata.msreport.util;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.dto.response.TransactionResponse;
import io.reactivex.rxjava3.core.Flowable;

import java.time.LocalDateTime;

public class TransactionTestUtil {

  public static Flowable<ObjectResponse> generateTransactionResponse() {
    var transaction1 = TransactionResponse.builder()
            .type("Retiro")
            .amount(500.00)
            .date(LocalDateTime.now())
            .build();

    var transaction2 = TransactionResponse.builder()
            .type("Deposito")
            .amount(2500.00)
            .date(LocalDateTime.now())
            .build();

    var obj1 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(transaction1)
            .build();

    var obj2 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(transaction2)
            .build();

    return Flowable.just(obj1, obj2);
  }

}
