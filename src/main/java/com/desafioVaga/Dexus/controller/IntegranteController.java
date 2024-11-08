package com.desafioVaga.Dexus.controller;

import com.desafioVaga.Dexus.model.Integrante;
import com.desafioVaga.Dexus.repository.IntegranteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {


    @Autowired
    private IntegranteRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity<Integrante> cadastrar(@Valid @RequestBody Integrante integrante, UriComponentsBuilder builder) {
        Integrante novoIntegrante = repository.save(integrante);

        // Cria a URI para o novo recurso criado
        var uri = builder.path("/integrantes/{id}").buildAndExpand(novoIntegrante.getId()).toUri();

        // Retorna a resposta com status CREATED e a URI do novo integrante
        return ResponseEntity.created(uri).body(novoIntegrante);
    }
}