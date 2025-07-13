package com.inventarios.servicio;

import com.inventarios.modelo.Producto;

import java.util.List;

/**
 * Interfaz que define el contrato para operaciones de productos
 * Implementa el patrón de diseño Strategy y facilita testing con mocks
 * Define las operaciones CRUD básicas para el dominio de productos
 */
public interface IProductoServicio {

    /** Obtiene todos los productos del inventario */
    List<Producto> listarProductos();

    /** Busca un producto por su identificador único */
    Producto buscarProductoPorId(Integer idProducto);

    /** Guarda un producto (crear nuevo o actualizar existente) */
    Producto guardarProducto(Producto producto);

    /** Elimina un producto por su identificador */
    void eliminarProductoPorId(Integer idProducto);

}
