package com.nttdata.msreport.infrastructure.mapper;

import com.nttdata.msreport.domain.model.AverageBalance;
import com.nttdata.msreport.infrastructure.dao.entity.AverageBalanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AverageBalanceMapper {

  AverageBalanceMapper INSTANCE = Mappers.getMapper(AverageBalanceMapper.class);

  default AverageBalance map(AverageBalanceEntity entity) {
    return AverageBalance.builder()
            .average(entity.getAverage())
            .date(entity.getDate())
            .build();
  }

}
