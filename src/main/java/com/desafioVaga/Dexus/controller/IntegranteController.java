package com.desafioVaga.Dexus.controller;

import com.desafioVaga.Dexus.dtos.FiltrarIntrgrante;
import com.desafioVaga.Dexus.dtos.IntegranteDTO;
import com.desafioVaga.Dexus.model.Integrante;
import com.desafioVaga.Dexus.repository.IntegranteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {


    @Autowired
    private IntegranteRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity<Integrante> cadastrar(@Valid @RequestBody Integrante integrante, UriComponentsBuilder builder) {
        Integrante novoIntegrante = repository.save(integrante);

        var uri = builder.path("/integrantes/{id}").buildAndExpand(novoIntegrante.getId()).toUri();

        return ResponseEntity.created(uri).body(novoIntegrante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntegranteDTO> listar(@PathVariable Long id) {
        var listarIntegrante = repository.findById(id);
        if (listarIntegrante.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new IntegranteDTO(listarIntegrante.get().getFranquia(), listarIntegrante.get().getNome(), listarIntegrante.get().getFuncao()));
    }

    @GetMapping("/funcaoComum")
    public ResponseEntity<FiltrarIntrgrante> funcaoMaisComum(@RequestParam(required = false) String dataInicio,
                                                             @RequestParam(required = false) String dataFim) {
        var integrantes = repository.findAll();  // Recupera todos os integrantes do banco
        if (integrantes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        Map<String, Long> funcaoCount = integrantes.stream()
                .collect(Collectors.groupingBy(Integrante::getFuncao, Collectors.counting()));


        String funcaoMaisComum = funcaoCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        // Retorna a função mais comum
        return ResponseEntity.ok(new FiltrarIntrgrante(funcaoMaisComum));
    }

    @GetMapping("/contagemPorFranquia")
    public ResponseEntity<Map<String, Long>> contagemPorFranquia(@RequestParam(required = false) String dataInicio,
                                                                 @RequestParam(required = false) String dataFim) {

        var integrantes = repository.findAll();
        if (integrantes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        Map<String, Long> franquiaCount = integrantes.stream()
                .collect(Collectors.groupingBy(Integrante::getFranquia, Collectors.counting()));


        Map<String, Long> topFranquias = franquiaCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)  // Pega as 3 mais frequentes
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new  // Garante que a ordem será mantida
                ));

        return ResponseEntity.ok(topFranquias);
    }


}