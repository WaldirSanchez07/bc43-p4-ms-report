package com.nttdata.msreport.application.mapper;

import com.nttdata.msreport.application.dto.response.TransactionResponse;
import com.nttdata.msreport.domain.model.Transaction;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionResponseMapper {

  TransactionResponseMapper INSTANCE = Mappers.getMapper(TransactionResponseMapper.class);

  default TransactionResponse map(Transaction transaction) {
    return TransactionResponse.builder()
            .type(transaction.getType())
            .description(transaction.getDescription())
            .amount(transaction.getAmount())
            .date(LocalDateTime.now())
            .build();
  }

}
