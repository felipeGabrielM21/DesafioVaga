package com.desafioVaga.Dexus.dtos;

import java.time.LocalDate;
import java.util.List;

public record TimeDto(

        LocalDate data,
        List composicaoTime) {
}
