package com.desafioVaga.Dexus.dtos;

import com.desafioVaga.Dexus.model.ComposicaoTime;

import java.time.LocalDate;
import java.util.List;

public record TimeDto(
        LocalDate data,
        List composicaoTime) {
}
