package com.reservas.repository;

import com.reservas.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AgendamentoRepository
        extends JpaRepository<Agendamento, Long> {

    boolean existsByDataAgendamentoAndHoraAgendamentoAndSala_CodigoSala(
            LocalDate dataAgendamento,
            LocalTime horaAgendamento,
            Long codigoSala
    );

    List<Agendamento> findByDataAgendamento(
            LocalDate dataAgendamento);

    List<Agendamento>
    findByDataAgendamentoAndSala_CodigoSala(
            LocalDate dataAgendamento,
            Long codigoSala
    );

    List<Agendamento>
    findByDataAgendamentoAndHoraAgendamentoAndSala_CodigoSala(
            LocalDate dataAgendamento,
            LocalTime horaAgendamento,
            Long codigoSala
    );

}