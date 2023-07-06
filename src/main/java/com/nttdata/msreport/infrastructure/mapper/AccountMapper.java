package com.nttdata.msreport.infrastructure.mapper;

import com.nttdata.msreport.domain.model.Account;
import com.nttdata.msreport.infrastructure.dao.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Account mapper.
 */
@Mapper
public interface AccountMapper {

  AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

  /**
   * AccountEntity to Account.

   * @param account type AccountEntity.
   * @return type Account.
   */
  default Account map(AccountEntity account) {
    return Account.builder()
            .id(account.getId())
            .accountNumber(account.getAccountNumber())
            .clientId(account.getClientId())
            .passiveProductId(account.getPassiveProductId())
            .activeProductId(account.getActiveProductId())
            .build();
  }

}
