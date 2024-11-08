package com.desafioVaga.Dexus.controller;


import com.desafioVaga.Dexus.dtos.ComposicaoTimeDto;
import com.desafioVaga.Dexus.repository.ComposicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/composicao-time")
public class ComposicaoController {


    @Autowired
    private ComposicaoRepository repository;


    @GetMapping("/{id}")
    public ResponseEntity<ComposicaoTimeDto> listar(@PathVariable Long id) {
        var listarComposicao = repository.findById(id);
        if (listarComposicao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ComposicaoTimeDto(listarComposicao.get().getTime(), listarComposicao.get().getIntegrante()));
    }

}
