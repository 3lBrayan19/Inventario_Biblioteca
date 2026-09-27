package com.biblioteca.inventario.repository;

import com.biblioteca.inventario.model.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {
}
