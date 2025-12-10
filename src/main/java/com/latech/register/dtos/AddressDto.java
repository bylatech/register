package com.latech.register.dtos;

import jakarta.persistence.Embeddable;

@Embeddable
public record AddressDto(
        String cep,
        String logradouro,
        String localidade) {
}
