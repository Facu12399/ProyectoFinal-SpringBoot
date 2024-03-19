package com.example.ProyectoFinalTodoCodeSpringBoot.service;

import com.example.ProyectoFinalTodoCodeSpringBoot.dto.MayorVentaDto;
import com.example.ProyectoFinalTodoCodeSpringBoot.dto.VentasDelDiaDto;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Cliente;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Producto;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    //crear venta
    public void crearVenta(Venta venta);

    //leer ventas
    public List<Venta> leerVenta();

    //encontrar venta
    public Venta encontrarVenta(Long id);

    //eliminar venta
    public void eliminarVenta(Long id);

    //editar venta
    public void editarVenta(Venta venta);

    //leer todos los productos de una venta
    public List<Producto> encontrarProductosDeUnaVenta(Long id);

    //obtener monto vendido y cantidad total de ventas en un dia
    public VentasDelDiaDto traerVentasDelDia(LocalDate fecha);

    //obtener codigo_venta, total, cantidad_productos, nombre_cliente, apellido_cliente;
    public MayorVentaDto traerClienteMayorVenta();

}
