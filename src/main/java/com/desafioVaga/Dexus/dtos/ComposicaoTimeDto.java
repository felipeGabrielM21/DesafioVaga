package com.desafioVaga.Dexus.dtos;

import com.desafioVaga.Dexus.model.Integrante;
import com.desafioVaga.Dexus.model.Time;

public record ComposicaoTimeDto(

        Time time,
        Integrante integrante) {
}
