package com.desafioVaga.Dexus.controller;


import com.desafioVaga.Dexus.model.ComposicaoTime;
import com.desafioVaga.Dexus.repository.ComposicaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@RestController
@RequestMapping("/composicao-time")
public class ComposicaoController {


    private ComposicaoRepository composicaoTimeService;

    // Criar uma nova composição de time
    @PostMapping
    public ResponseEntity<ComposicaoTime> createComposicaoTime(@RequestBody ComposicaoTime composicaoTime) {
        ComposicaoTime createdComposicao = composicaoTimeService.save(composicaoTime);
        return new ResponseEntity<>(createdComposicao, HttpStatus.CREATED);
    }
}
