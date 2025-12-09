package com.latech.register.dtos;

public record AddressDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao,
        String ddd) {
}
