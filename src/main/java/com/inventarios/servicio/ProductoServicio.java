package com.inventarios.servicio;

import com.inventarios.modelo.Producto;
import com.inventarios.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que implementa la lógica de negocio para productos
 * Capa intermedia entre el controlador y el repositorio
 * Aquí se implementan las reglas de negocio y validaciones
 */
@Service // Marca la clase como componente de servicio de Spring
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    /**
     * Obtiene todos los productos del inventario
     * @return Lista completa de productos
     */
    @Override
    public List<Producto> listarProductos() {
        return this.productoRepositorio.findAll(); // Delega al repositorio JPA
    }

    /**
     * Busca un producto por su ID
     * @param idProducto Identificador del producto
     * @return Producto encontrado o null si no existe
     */
    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        // Optional.orElse(null) maneja el caso cuando no se encuentra el producto
        Producto producto  = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    /**
     * Guarda un producto (crear o actualizar)
     * @param producto Producto a guardar
     * @return Producto guardado con ID generado (si es nuevo)
     */
    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepositorio.save(producto); // JPA save() hace INSERT o UPDATE
    }

    /**
     * Elimina un producto por su ID
     * @param idProducto ID del producto a eliminar
     */
    @Override
    public void eliminarProductoPorId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto); // Eliminación física de BD
    }
}
