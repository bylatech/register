package com.latech.register.clients;

import com.latech.register.dtos.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface LocationClient {

    @GetMapping("/{cep}/json")
    AddressDto searchAddress(@PathVariable String cep);

}
