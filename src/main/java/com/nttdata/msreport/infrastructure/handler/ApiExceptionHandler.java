package com.nttdata.msreport.infrastructure.handler;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

@ControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(WebExchangeBindException.class)
  @ResponseBody
  public Single<ErrorResponse> handleValidationException(WebExchangeBindException ex) {
    Integer statusCode = HttpStatus.UNPROCESSABLE_ENTITY.value();
    return Flowable.fromIterable(ex.getFieldErrors())
            .toMap(FieldError::getField, FieldError::getDefaultMessage, HashMap::new)
            .map(errors -> new ErrorResponse("Error de validación", statusCode, errors));
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(Throwable.class)
  @ResponseBody
  public Single<ErrorResponse> handleBadRequestException(Throwable ex) {
    Integer statusCode = 400;
    String message = ex.getMessage();
    return Single.just(new ErrorResponse(message, statusCode, null));
  }

}
