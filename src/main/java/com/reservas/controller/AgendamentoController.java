package com.reservas.controller;

import com.reservas.entity.Agendamento;
import com.reservas.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.time.LocalTime;


@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(
            AgendamentoService service) {

        this.service = service;
    }

    @PostMapping
    public Agendamento cadastrarAgendamento(
            @RequestBody Agendamento agendamento) {

        return service.cadastrarAgendamento(
                agendamento);
    }

    @GetMapping
    public List<Agendamento>
    consultarAgendamentos() {

        return service.consultarAgendamentos();
    }

    @GetMapping("/{id}")
    public Agendamento
    consultarAgendamentoPorId(
            @PathVariable Long id) {

        return service
                .consultarAgendamentoPorId(id);
    }

    @PutMapping("/{id}")
    public Agendamento editarAgendamento(
            @PathVariable Long id,
            @RequestBody
            Agendamento agendamento) {

        return service.editarAgendamento(
                id,
                agendamento);
    }

    @GetMapping("/data/{data}")
    public Object consultarAgendamentosPorData(@PathVariable LocalDate data) {
        List<Agendamento> agendamentos = service.consultarAgendamentosPorData(data);

        if (agendamentos.isEmpty()) {
            return Map.of(
                    "mensagem",
                    "Não existem agendamentos para esta data."
            );
        }

        return agendamentos;
    }

    @GetMapping("/data/{data}/sala/{codigoSala}")
    public Object consultarAgendamentosPorDataESala(@PathVariable LocalDate data, @PathVariable Long codigoSala) {
        List<Agendamento> agendamentos = service.consultarAgendamentosPorDataESala(
                        data,
                        codigoSala
                );

        if (agendamentos.isEmpty()) {
            return Map.of(
                    "mensagem",
                    "Neste dia, todos os horários da sala estão disponíveis."
            );
        }

        return agendamentos;
    }

    @DeleteMapping("/{id}")
    public void excluirAgendamento(@PathVariable Long id) {
        service.excluirAgendamento(id);
    }

    @GetMapping(
            "/disponibilidade/{data}/{hora}/sala/{codigoSala}"
    )
    public Object consultarDisponibilidadeSala(
            @PathVariable LocalDate data,
            @PathVariable LocalTime hora,
            @PathVariable Long codigoSala) {

        List<Agendamento> agendamentos =
                service.consultarDisponibilidadeSala(
                        data,
                        hora,
                        codigoSala
                );

        if (agendamentos.isEmpty()) {

            return Map.of(
                    "mensagem",
                    "A sala está disponível neste horário."
            );
        }

        return agendamentos;
    }


}