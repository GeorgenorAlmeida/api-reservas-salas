package com.reservas.service;

import com.reservas.entity.Sala;
import com.reservas.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public Sala cadastrarSala(Sala sala) {

        boolean salaExiste =
                repository.existsByNomeSala(
                        sala.getNomeSala());

        if (salaExiste) {

            throw new RuntimeException(
                    "Já existe uma sala com este nome.");
        }

        return repository.save(sala);
    }

    public List<Sala> consultarSalas() {

        return repository.findAll();
    }

    public Sala consultarSalaPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Sala não encontrada."));
    }

    public Sala editarSala(
            Long id,
            Sala salaAtualizada) {

        Sala sala =
                consultarSalaPorId(id);

        sala.setNomeSala(
                salaAtualizada.getNomeSala());

        sala.setTipoSala(
                salaAtualizada.getTipoSala());

        return repository.save(sala);
    }

    public void excluirSala(Long id) {

        Sala sala =
                consultarSalaPorId(id);

        repository.delete(sala);
    }
}