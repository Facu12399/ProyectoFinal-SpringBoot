package com.example.ProyectoFinalTodoCodeSpringBoot.controller;

import com.example.ProyectoFinalTodoCodeSpringBoot.dto.MayorVentaDto;
import com.example.ProyectoFinalTodoCodeSpringBoot.dto.VentasDelDiaDto;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Producto;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Venta;
import com.example.ProyectoFinalTodoCodeSpringBoot.service.IVentaService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class VentaController {

    @Autowired
    IVentaService ventaServ;

    @PostMapping ("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaServ.crearVenta(venta);
        return "La venta se creo con exito";
    }

    @GetMapping ("/ventas")
    public List<Venta> leerVentas(){
        return ventaServ.leerVenta();
    }

    @GetMapping ("/ventas/{codigo_venta}")
    public Venta traerVenta(@PathVariable Long codigo_venta){
        return ventaServ.encontrarVenta(codigo_venta);
    }

    @DeleteMapping ("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        ventaServ.eliminarVenta(codigo_venta);
        return "La venta se elimino con exito";
    }

    @PutMapping ("/ventas/editar")
    public Venta editarVenta(@RequestBody Venta venta){
        ventaServ.editarVenta(venta);
        return ventaServ.encontrarVenta(venta.getCodigo_venta());
    }

    @GetMapping ("/ventas/productos/{codigo_venta}")
    public List<Producto> traerProductosDeVenta(@PathVariable Long codigo_venta){
        return ventaServ.encontrarProductosDeUnaVenta(codigo_venta);
    }

    @GetMapping ("/ventas/dia")
    public VentasDelDiaDto traerProductosDeVenta(@RequestParam @JsonFormat(pattern = "yyyy/MM/dd") LocalDate fecha_venta){
        return ventaServ.traerVentasDelDia(fecha_venta);
    }

    @GetMapping ("/ventas/mayor_venta")
    public MayorVentaDto traerMayorVenta(){
        return ventaServ.traerClienteMayorVenta();
    }
}
