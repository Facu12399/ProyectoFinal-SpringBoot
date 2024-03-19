package com.example.ProyectoFinalTodoCodeSpringBoot.controller;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Cliente;
import com.example.ProyectoFinalTodoCodeSpringBoot.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class ClienteController {

    @Autowired
    IClienteService clienteServ;

    @PostMapping ("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteServ.crearCliente(cliente);
        return "El cliente se creo con exito";
    }

    @GetMapping ("/clientes")
    public List<Cliente> traerClientes(){
        return clienteServ.leerCliente();
    }

    @GetMapping ("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente){
        return clienteServ.encontrarCliente(id_cliente);
    }

    @DeleteMapping ("/clientes/eliminar/{id_cliente}")
    public String eliminarCliente(@PathVariable Long id_cliente){
        clienteServ.eliminarCliente(id_cliente);
        return "El cliente se elimino con exito";
    }

    @PutMapping ("/clientes/editar")
    public Cliente editarCliente(@RequestBody Cliente cliente){
        clienteServ.editarCliente(cliente);
        return clienteServ.encontrarCliente(cliente.getId_cliente());
    }


}
