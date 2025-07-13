package com.inventarios.repositorio;

import com.inventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para operaciones de base de datos de productos
 * Extiende JpaRepository que proporciona métodos CRUD automáticamente:
 * - findAll(), findById(), save(), deleteById(), etc.
 * Spring Data JPA genera la implementación automáticamente
 * 
 * @param <Producto> Entidad que maneja
 * @param <Integer> Tipo de dato de la clave primaria
 */
public interface ProductoRepositorio extends JpaRepository <Producto, Integer> {
    // No necesita implementación - Spring Data JPA la genera automáticamente
    // Métodos disponibles: findAll(), findById(), save(), deleteById(), count(), etc.
}
