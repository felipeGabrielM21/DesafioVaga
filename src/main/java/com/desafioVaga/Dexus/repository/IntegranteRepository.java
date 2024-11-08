package com.desafioVaga.Dexus.repository;

import com.desafioVaga.Dexus.model.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository  extends JpaRepository<Integrante, Long> {
}
