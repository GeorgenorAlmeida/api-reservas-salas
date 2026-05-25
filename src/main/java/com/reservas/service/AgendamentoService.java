package com.reservas.service;

import com.reservas.entity.Agendamento;
import com.reservas.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;
import com.reservas.repository.ClienteRepository;
import com.reservas.repository.SalaRepository;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final ClienteRepository clienteRepository;
    private final SalaRepository salaRepository;

    public AgendamentoService(
            AgendamentoRepository repository,
            ClienteRepository clienteRepository,
            SalaRepository salaRepository) {

        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.salaRepository = salaRepository;
    }

    public Agendamento cadastrarAgendamento(
            Agendamento agendamento) {

        Long codigoCliente =
                agendamento
                        .getCliente()
                        .getCodigoCliente();

        boolean clienteExiste =
                clienteRepository.existsById(
                        codigoCliente);

        if (!clienteExiste) {

            throw new RuntimeException(
                    "Cliente não encontrado.");
        }

        Long codigoSala =
                agendamento
                        .getSala()
                        .getCodigoSala();

        boolean salaExiste =
                salaRepository.existsById(
                        codigoSala);

        if (!salaExiste) {

            throw new RuntimeException(
                    "Sala não encontrada.");
        }

        boolean horarioExiste =
                repository
                        .existsByDataAgendamentoAndHoraAgendamentoAndSala_CodigoSala(
                                agendamento.getDataAgendamento(),
                                agendamento.getHoraAgendamento(),
                                codigoSala
                        );

        if (horarioExiste) {

            throw new RuntimeException(
                    "Já existe um agendamento para esta sala neste horário.");
        }

        if (agendamento.getStatusAgendamento() == null
                || agendamento.getStatusAgendamento().isEmpty()) {

            agendamento.setStatusAgendamento(
                    "RESERVADO");
        }

        return repository.save(agendamento);
    }

    public List<Agendamento>
    consultarAgendamentos() {
        return repository.findAll();
    }

    public List<Agendamento>
    consultarAgendamentosPorData(LocalDate dataAgendamento) {
        return repository.findByDataAgendamento(dataAgendamento);
    }

    public List<Agendamento>
    consultarAgendamentosPorDataESala(LocalDate dataAgendamento,Long codigoSala) {
        return repository.findByDataAgendamentoAndSala_CodigoSala(
                        dataAgendamento,
                        codigoSala
                );
    }

    public List<Agendamento> consultarDisponibilidadeSala(
            LocalDate dataAgendamento,
            LocalTime horaAgendamento,
            Long codigoSala) {
        return repository
                .findByDataAgendamentoAndHoraAgendamentoAndSala_CodigoSala(
                        dataAgendamento,
                        horaAgendamento,
                        codigoSala
                );
    }

    public Agendamento consultarAgendamentoPorId(
            Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Agendamento não encontrado."));
    }

    public Agendamento editarAgendamento(
            Long id,
            Agendamento agendamentoAtualizado) {

        Agendamento agendamento =
                consultarAgendamentoPorId(id);

        agendamento.setCliente(
                agendamentoAtualizado.getCliente());

        agendamento.setSala(
                agendamentoAtualizado.getSala());

        agendamento.setDataAgendamento(
                agendamentoAtualizado
                        .getDataAgendamento());

        agendamento.setHoraAgendamento(
                agendamentoAtualizado
                        .getHoraAgendamento());

        agendamento.setStatusAgendamento(
                agendamentoAtualizado
                        .getStatusAgendamento());

        return repository.save(agendamento);
    }

    public void excluirAgendamento(Long id) {

        Agendamento agendamento =
                consultarAgendamentoPorId(id);

        repository.delete(agendamento);
    }
}