package com.nttdata.msreport.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AccountSummary model.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountSummary {

  private String id;
  private String productType;
  private String accountNumber;
  private Double balance;
  private LocalDate date;

}
