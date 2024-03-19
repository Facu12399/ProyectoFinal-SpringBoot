package com.example.ProyectoFinalTodoCodeSpringBoot.repository;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
