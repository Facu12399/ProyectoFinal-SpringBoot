package com.example.ProyectoFinalTodoCodeSpringBoot.service;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Cliente;
import com.example.ProyectoFinalTodoCodeSpringBoot.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository clienteRepo;

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> leerCliente() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public Cliente encontrarCliente(Long id) {
        Cliente cliente = clienteRepo.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        this.crearCliente(cliente);
    }
}
