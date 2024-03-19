package com.example.ProyectoFinalTodoCodeSpringBoot.service;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Cliente;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Producto;
import com.example.ProyectoFinalTodoCodeSpringBoot.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    IProductoRepository productoRepo;

    @Override
    public void crearProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> leerProducto() {
        return productoRepo.findAll();
    }

    @Override
    public Producto encontrarProducto(Long id) {
        Producto producto =  productoRepo.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public void editarProducto(Producto producto) {
        this.crearProducto(producto);
    }

    @Override
    public List<Producto> productosMenorACinco() {
        List<Producto> listaProductoCantidadMenorACinco = new ArrayList<Producto>();

        for (Producto producto : productoRepo.findAll()){
            if (producto.getCantidad_disponible() < 5){
                listaProductoCantidadMenorACinco.add(producto);
            }
        }

        return listaProductoCantidadMenorACinco;
    }

}
