package com.nttdata.msreport.application.mapper;

import com.nttdata.msreport.application.dto.response.BalanceResponse;
import com.nttdata.msreport.domain.model.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceResponseMapper {

  BalanceResponseMapper INSTANCE = Mappers.getMapper(BalanceResponseMapper.class);

  default BalanceResponse map(Balance balance) {
    return BalanceResponse.builder()
            .amount(balance.getAmount())
            .date(balance.getDate())
            .build();
  }

}
