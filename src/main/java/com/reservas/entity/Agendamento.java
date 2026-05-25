package com.reservas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_agendamento")
    private Long codigoAgendamento;

    @ManyToOne
    @JoinColumn(
            name = "codigo_cliente",
            nullable = false
    )
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(
            name = "codigo_sala",
            nullable = false
    )
    private Sala sala;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    @Column(name = "hora_agendamento")
    private LocalTime horaAgendamento;

    @Column(name = "status_agendamento")
    private String statusAgendamento;

    public Long getCodigoAgendamento() {
        return codigoAgendamento;
    }

    public void setCodigoAgendamento(Long codigoAgendamento) {
        this.codigoAgendamento = codigoAgendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(
            LocalDate dataAgendamento) {

        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHoraAgendamento() {
        return horaAgendamento;
    }

    public void setHoraAgendamento(
            LocalTime horaAgendamento) {

        this.horaAgendamento = horaAgendamento;
    }

    public String getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(
            String statusAgendamento) {

        this.statusAgendamento =
                statusAgendamento;
    }
}