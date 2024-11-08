package com.desafioVaga.Dexus.controller;

import com.desafioVaga.Dexus.dtos.TimeDto;
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

    @Autowired
    private TimeRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity<Time> cadastrar(@Valid @RequestBody TimeDto dados, UriComponentsBuilder builder) {
        Time novoTime = new Time(dados);

        novoTime = repository.save(novoTime);

        var uri = builder.path("/time/{id}").buildAndExpand(novoTime.getId()).toUri();

        return ResponseEntity.created(uri).body(novoTime);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TimeDto> listar(@PathVariable Long id) {
        var listarTime = repository.findById(id);
        if (listarTime.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new TimeDto(listarTime.get().getData(), listarTime.get().getComposicaoTime()));
    }
}