package com.nttdata.msreport.util;

import com.nttdata.msreport.application.dto.response.BalanceResponse;
import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.domain.model.AverageBalance;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

import java.time.LocalDateTime;

public class BalanceTestUtil {

  public static Maybe<ObjectResponse> generateBalanceResponse() {
    var balance = BalanceResponse.builder()
            .amount(2500.00)
            .date(LocalDateTime.now())
            .build();

    var obj = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(balance)
            .build();

    return Maybe.just(obj);
  }

  public static Flowable<ObjectResponse> generateAverageBalances() {
    var average1 = AverageBalance.builder()
            .average(3500.50)
            .date("2023-07-06")
            .build();

    var average2 = AverageBalance.builder()
            .average(4500.50)
            .date("2023-07-06")
            .build();

    var obj1 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(average1)
            .build();

    var obj2 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(average2)
            .build();

    return Flowable.just(obj1, obj2);
  }

}
