package com.example.ProyectoFinalTodoCodeSpringBoot.service;

import com.example.ProyectoFinalTodoCodeSpringBoot.dto.MayorVentaDto;
import com.example.ProyectoFinalTodoCodeSpringBoot.dto.VentasDelDiaDto;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Producto;
import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Venta;
import com.example.ProyectoFinalTodoCodeSpringBoot.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    IVentaRepository ventaRepo;

    @Override
    public void crearVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> leerVenta() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public Venta encontrarVenta(Long id) {
        Venta venta = ventaRepo.findById(id).orElse(null);
        return venta;
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editarVenta(Venta venta) {
        this.crearVenta(venta);
    }

    @Override
    public List<Producto> encontrarProductosDeUnaVenta(Long id) {
        List<Producto> listaProductosDeVenta = new ArrayList<Producto>();

        for (Venta venta : ventaRepo.findAll()){
            if (venta.getCodigo_venta() == id){
                for (int i = 0; i < venta.getListaProductos().size(); i++) {
                    listaProductosDeVenta.add(venta.getListaProductos().get(i));
                }
            }
        }

        return listaProductosDeVenta;
    }

    @Override
    public VentasDelDiaDto traerVentasDelDia(LocalDate fecha) {
        VentasDelDiaDto ventasDelDia = new VentasDelDiaDto();
        double sumaMonto = 0;
        int cantVentas = 0;

        for (Venta venta : ventaRepo.findAll()){
            if (venta.getFecha_venta().isEqual(fecha)){
                sumaMonto += venta.getTotal();
                cantVentas++;
            }
        }
        ventasDelDia.setFecha_ventas(fecha);
        ventasDelDia.setTotal_ventas(sumaMonto);
        ventasDelDia.setCantidad_ventas(cantVentas);

        return ventasDelDia;
    }

    @Override
    public MayorVentaDto traerClienteMayorVenta() {
        MayorVentaDto mayorVentaDto = new MayorVentaDto();

        double montoTotal = 0;

        for (Venta venta : ventaRepo.findAll()){
            if (venta.getTotal() > montoTotal){
                montoTotal = venta.getTotal();
            }
        }

        for (Venta venta : ventaRepo.findAll()){
            if (montoTotal == venta.getTotal()){
                mayorVentaDto.setCodigo_venta(venta.getCodigo_venta());
                mayorVentaDto.setTotal(venta.getTotal());
                mayorVentaDto.setCantidad_productos(venta.getListaProductos().size());
                mayorVentaDto.setNombre_cliente(venta.getUnCliente().getNombre());
                mayorVentaDto.setApellido_cliente(venta.getUnCliente().getApellido());
            }
        }
        return mayorVentaDto;
    }
}
