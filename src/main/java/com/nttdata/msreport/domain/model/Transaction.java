package com.nttdata.msreport.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transaction model.
 */
@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@NoArgsConstructor
public class Transaction {

  private String id;
  private String type;
  private String description;
  private String accountId;
  private String anotherAccountId;
  private Double amount;
  private LocalDateTime date;

}
