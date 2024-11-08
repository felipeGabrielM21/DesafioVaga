package com.desafioVaga.Dexus.dtos;

import jakarta.validation.constraints.NotNull;

public record IntegranteDTO(

        @NotNull
        String franquia,

        @NotNull
        String nome,

        @NotNull
        String funcao) {
}
