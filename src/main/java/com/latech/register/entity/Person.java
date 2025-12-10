package com.latech.register.entity;

import com.latech.register.dtos.PersonDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String cpf;
    private String cep;
    private String logradouro;
    private String localidade;


    public static Person dtoFromPersonData(PersonDto dto) {
        return Person.builder()
                .name(dto.name())
                .lastName(dto.lastName())
                .cpf(dto.cpf())
                .cep(dto.cep())
                .build();
    }
}