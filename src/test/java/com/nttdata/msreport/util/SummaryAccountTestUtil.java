package com.nttdata.msreport.util;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.domain.model.AccountSummary;
import io.reactivex.rxjava3.core.Flowable;

import java.time.LocalDate;

public class SummaryAccountTestUtil {

  public static Flowable<ObjectResponse> generateList() {
    var summary1 = AccountSummary.builder()
            .accountNumber("1")
            .balance(2000.00)
            .productType("Cuenta de Ahorro")
            .date(LocalDate.now())
            .build();

    var summary2 = AccountSummary.builder()
            .accountNumber("1")
            .balance(2500.00)
            .productType("Cuenta de Ahorro")
            .date(LocalDate.now())
            .build();

    var obj1 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(summary1)
            .build();

    var obj2 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(summary2)
            .build();

    return Flowable.just(obj1, obj2);
  }

}
