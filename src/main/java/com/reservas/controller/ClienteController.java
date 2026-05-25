package com.reservas.controller;

import com.reservas.entity.Cliente;
import com.reservas.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public Cliente cadastrarCliente(
            @RequestBody Cliente cliente) {

        return service.cadastrarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> consultarClientes() {

        return service.consultarClientes();
    }

    @GetMapping("/{id}")
    public Cliente consultarClientePorId(
            @PathVariable Long id) {

        return service.consultarClientePorId(id);
    }

    @PutMapping("/{id}")
    public Cliente editarCliente(
            @PathVariable Long id,
            @RequestBody Cliente cliente) {

        return service.editarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(
            @PathVariable Long id) {

        service.excluirCliente(id);
    }
}