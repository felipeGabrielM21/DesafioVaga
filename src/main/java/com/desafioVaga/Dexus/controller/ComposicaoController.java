package com.desafioVaga.Dexus.controller;


import com.desafioVaga.Dexus.dtos.ComposicaoTimeDto;
import com.desafioVaga.Dexus.model.ComposicaoTime;
import com.desafioVaga.Dexus.repository.ComposicaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@RestController
@RequestMapping("/composicao-time")
public class ComposicaoController {


    @Autowired
    private ComposicaoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<ComposicaoTime> createComposicaoTime(@RequestBody ComposicaoTime composicaoTime) {
        ComposicaoTime createdComposicao = repository.save(composicaoTime);
        return new ResponseEntity<>(createdComposicao, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComposicaoTimeDto> listar(@PathVariable Long id) {
        var listarComposicao = repository.findById(id);
        if (listarComposicao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ComposicaoTimeDto(listarComposicao.get().getTime(), listarComposicao.get().getIntegrante()));
    }

}
