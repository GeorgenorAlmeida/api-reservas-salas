package com.reservas.controller;

import com.reservas.entity.Sala;
import com.reservas.service.SalaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @PostMapping
    public Sala cadastrarSala(
            @RequestBody Sala sala) {

        return service.cadastrarSala(sala);
    }

    @GetMapping
    public List<Sala> consultarSalas() {

        return service.consultarSalas();
    }

    @GetMapping("/{id}")
    public Sala consultarSalaPorId(
            @PathVariable Long id) {

        return service.consultarSalaPorId(id);
    }

    @PutMapping("/{id}")
    public Sala editarSala(
            @PathVariable Long id,
            @RequestBody Sala sala) {

        return service.editarSala(id, sala);
    }

    @DeleteMapping("/{id}")
    public void excluirSala(
            @PathVariable Long id) {

        service.excluirSala(id);
    }
}