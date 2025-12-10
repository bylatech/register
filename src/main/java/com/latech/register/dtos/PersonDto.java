package com.latech.register.dtos;

import jakarta.persistence.Embeddable;

@Embeddable
public record PersonDto(
        String name,
        String lastName,
        String cpf,
        String cep) {
}
