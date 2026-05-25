package com.reservas.repository;

import com.reservas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {

    boolean existsByCpfCnpj(String cpfCnpj);
}