
package com.reservas.service;

import com.reservas.entity.Cliente;
import com.reservas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrarCliente(Cliente cliente) {

        boolean cpfExiste =
                repository.existsByCpfCnpj(
                        cliente.getCpfCnpj());

        if (cpfExiste) {

            throw new RuntimeException(
                    "CPF/CNPJ já cadastrado.");
        }

        return repository.save(cliente);
    }

    public List<Cliente> consultarClientes() {

        return repository.findAll();
    }

    public Cliente consultarClientePorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Cliente não encontrado."));
    }

    public Cliente editarCliente(
            Long id,
            Cliente clienteAtualizado) {

        Cliente cliente =
                consultarClientePorId(id);

        cliente.setNome(
                clienteAtualizado.getNome());

        cliente.setSobrenome(
                clienteAtualizado.getSobrenome());

        cliente.setTipoPessoa(
                clienteAtualizado.getTipoPessoa());

        cliente.setEmail(
                clienteAtualizado.getEmail());

        cliente.setTelefone(
                clienteAtualizado.getTelefone());

        return repository.save(cliente);
    }

    public void excluirCliente(Long id) {

        Cliente cliente =
                consultarClientePorId(id);

        repository.delete(cliente);
    }

    public List<Cliente> consultarPorNome(String nome) {

        List<Cliente> clientes = clienteRepository.findByNomeContainingIgnoreCase(nome);

        if (clientes.isEmpty()) {
            throw new RuntimeException("Nenhum cliente encontrado com este nome.");
        }

        return clientes;
    }

}