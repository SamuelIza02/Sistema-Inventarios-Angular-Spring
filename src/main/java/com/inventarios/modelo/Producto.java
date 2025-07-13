package com.inventarios.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entidad JPA que representa un producto en el sistema de inventarios
 * Utiliza Jakarta Persistence para mapeo objeto-relacional
 * Lombok reduce el código boilerplate generando automáticamente getters, setters, etc.
 */
@Entity // Marca la clase como entidad JPA para mapeo a tabla de BD
@Data // Lombok: genera getters, setters, equals, hashCode automáticamente
@NoArgsConstructor // Lombok: constructor sin parámetros (requerido por JPA)
@AllArgsConstructor // Lombok: constructor con todos los parámetros
@ToString // Lombok: genera método toString() automáticamente
public class Producto {

    @Id // Marca el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento en BD
    Integer idProducto; // Identificador único del producto
    
    String descripcion; // Nombre o descripción del producto
    Double precio; // Precio unitario del producto
    Integer existencia; // Cantidad disponible en inventario
}
