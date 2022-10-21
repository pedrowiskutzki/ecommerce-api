package com.ecommerce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.consumodeapi.domain.model.Endereco;
import com.serratec.consumodeapi.domain.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    private ResponseEntity<Endereco> buscaEndereco(@PathVariable("cep") String cep) {
        Endereco endereco = enderecoService.getEndereco(cep);
        return ResponseEntity.ok(endereco);
    }

}
