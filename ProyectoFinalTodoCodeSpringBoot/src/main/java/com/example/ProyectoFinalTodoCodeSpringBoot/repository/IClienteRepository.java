package com.example.ProyectoFinalTodoCodeSpringBoot.repository;

import com.example.ProyectoFinalTodoCodeSpringBoot.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
