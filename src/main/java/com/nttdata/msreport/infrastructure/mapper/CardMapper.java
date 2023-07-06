package com.nttdata.msreport.infrastructure.mapper;

import com.nttdata.msreport.domain.model.Card;
import com.nttdata.msreport.infrastructure.dao.entity.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

  CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

  default Card map(CardEntity card) {
    return Card.builder()
            .id(card.getId())
            .cardType(card.getCardType())
            .cardNumber(card.getCardNumber())
            .clientId(card.getClientId())
            .cvv(card.getCvv())
            .mainAccountId(card.getMainAccountId())
            .dueDate(card.getDueDate())
            .build();
  }

}
