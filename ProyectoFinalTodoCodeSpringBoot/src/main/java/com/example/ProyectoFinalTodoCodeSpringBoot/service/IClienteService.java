package com.example.ProyectoFinalTodoCodeSpringBoot.service;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Cliente;

import java.util.List;

public interface IClienteService {

    //crear cliente
    public void crearCliente(Cliente cliente);

    //leer clientes
    public List<Cliente> leerCliente();

    //encontrar cliente
    public Cliente encontrarCliente(Long id);

    //eliminar cliente
    public void eliminarCliente(Long id);

    //editar cliente
    public void editarCliente(Cliente cliente);
}
