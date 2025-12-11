package com.latech.register.controller;

import com.latech.register.dtos.PersonDto;
import com.latech.register.entity.Person;
import com.latech.register.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
@Slf4j
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/person")
    public ResponseEntity<Person> savePerson(@RequestBody PersonDto personDto) {
        var personData = registerService.savePerson(Person.dtoFromPersonData(personDto));
        log.info("Saving/creating person... {}", personData);
        return ResponseEntity.status(HttpStatus.CREATED).body(personData);
    }
}
