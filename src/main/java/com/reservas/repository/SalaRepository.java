package com.reservas.repository;

import com.reservas.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository
        extends JpaRepository<Sala, Long> {

    boolean existsByNomeSala(String nomeSala);
}