package com.example.ProyectoFinalTodoCodeSpringBoot.controller;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Producto;
import com.example.ProyectoFinalTodoCodeSpringBoot.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class ProductoController {

    @Autowired
    IProductoService productoServ;

    @PostMapping ("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoServ.crearProducto(producto);
        return "El producto se creo con exito";
    }

    @GetMapping ("/productos")
    public List<Producto> leerProducto(){
        return productoServ.leerProducto();
    }

    @GetMapping ("/productos/{codigo_producto}")
    public Producto encontrarProducto(@PathVariable Long codigo_producto){
        return productoServ.encontrarProducto(codigo_producto);
    }

    @DeleteMapping ("/productos/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
        productoServ.eliminarProducto(codigo_producto);
        return "El producto se elimino con exito";
    }

    @PutMapping ("/productos/editar")
    public Producto editarProducto(@RequestBody Producto producto){
        productoServ.editarProducto(producto);
        return productoServ.encontrarProducto(producto.getCodigo_producto());
    }

    @GetMapping ("/productos/falta_stock")
    public List<Producto> productosMenorACinco(){
        return productoServ.productosMenorACinco();
    }

}
