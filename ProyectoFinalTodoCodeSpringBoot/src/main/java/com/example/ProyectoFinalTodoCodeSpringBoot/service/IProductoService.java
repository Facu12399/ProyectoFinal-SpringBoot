package com.example.ProyectoFinalTodoCodeSpringBoot.service;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Producto;

import java.util.List;

public interface IProductoService {

    //crear producto
    public void crearProducto(Producto producto);

    //leer productos
    public List<Producto> leerProducto();

    //encontrar productos
    public Producto encontrarProducto(Long id);

    //eliminar productos
    public void eliminarProducto(Long id);

    //editar producto
    public void editarProducto(Producto producto);

    //lista de productos cuya cantidad_disponible sea menor a 5
    public List<Producto> productosMenorACinco();
}
