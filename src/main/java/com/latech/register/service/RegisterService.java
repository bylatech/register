package com.latech.register.service;

import com.latech.register.clients.LocationClient;
import com.latech.register.entity.Person;
import com.latech.register.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterService {

    private final PersonRepository personRepository;
    private final LocationClient locationClient;

    public RegisterService(PersonRepository personRepository, LocationClient locationClient) {
        this.personRepository = personRepository;
        this.locationClient = locationClient;
    }

    public Person savePerson(Person person) {

        var cpf = personRepository.findByCpf(person.getCpf());
        if (cpf.isEmpty()) {
            searchAddress(person);
            personRepository.save(person);
            log.info("Saving person in database... {}", person);
        } else {
            throw new RuntimeException("Person exists");
        }

        return person;
    }

    private void searchAddress(Person person) {
        var personAddress = locationClient.searchAddress(person.getCep());
        log.info("Search person address.. {}", personAddress);
        person.setCep(personAddress.cep());
        person.setLogradouro(personAddress.logradouro());
        person.setLocalidade(personAddress.localidade());
    }

}
