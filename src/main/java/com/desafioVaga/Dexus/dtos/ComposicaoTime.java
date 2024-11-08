package com.desafioVaga.Dexus.dtos;

import com.desafioVaga.Dexus.model.Integrante;
import com.desafioVaga.Dexus.model.Time;

public record ComposicaoTime(

        Time time,
        Integrante integrante) {
}
