package com.example.ProyectoFinalTodoCodeSpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class VentasDelDiaDto {
    private LocalDate fecha_ventas;
    private double total_ventas;
    private int cantidad_ventas;

    public VentasDelDiaDto() {
    }

    public VentasDelDiaDto(LocalDate fecha_ventas, double total_ventas, int cantidad_ventas) {
        this.fecha_ventas = fecha_ventas;
        this.total_ventas = total_ventas;
        this.cantidad_ventas = cantidad_ventas;
    }
}
