package com.reservas.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "salas",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "nome_sala"
                )
        }
)
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_sala")
    private Long codigoSala;

    @Column(name = "nome_sala", nullable = false)
    private String nomeSala;

    @Column(name = "tipo_sala")
    private String tipoSala;

    public Long getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(Long codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }
}