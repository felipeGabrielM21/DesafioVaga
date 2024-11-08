package com.desafioVaga.Dexus.repository;

import com.desafioVaga.Dexus.model.ComposicaoTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposicaoRepository extends JpaRepository<ComposicaoTime, Long> {
}
