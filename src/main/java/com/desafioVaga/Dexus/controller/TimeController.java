package com.desafioVaga.Dexus.controller;

import com.desafioVaga.Dexus.model.Time;
import com.desafioVaga.Dexus.repository.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/time")
public class TimeController {

    private  TimeRepository repository;



    @Transactional
    @PostMapping
    public ResponseEntity<Time> cadastrar(@Valid @RequestBody TimeDto dados, UriComponentsBuilder builder) {
        // Cria um novo objeto Time a partir do DTO
        Time novoTime = new Time(dados);

        // Salva o novo time no banco de dados
        novoTime = repository.save(novoTime);

        // Cria a URI do novo recurso criado
        var uri = builder.path("/time/{id}").buildAndExpand(novoTime.getId()).toUri();

        // Retorna a resposta com status 201 Created e a URI do novo time
        return ResponseEntity.created(uri).body(novoTime);
    }


    @GetMapping
    public ResponseEntity<String> testar() {
        return ResponseEntity.ok("Funcionando");
    }
}