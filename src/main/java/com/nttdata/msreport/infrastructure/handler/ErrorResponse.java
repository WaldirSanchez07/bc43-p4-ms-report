package com.nttdata.msreport.infrastructure.handler;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ErrorResponse {

  private String message;
  private Integer status;
  private Map<String, String> errors;

}
