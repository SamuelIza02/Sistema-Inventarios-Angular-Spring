package com.inventarios.controlador;

import com.inventarios.excepcion.RecursoNoEncontradoExcepcion;
import com.inventarios.modelo.Producto;
import com.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para operaciones CRUD de productos
 * Implementa API RESTful con endpoints para inventario
 * Configurado para trabajar con frontend Angular
 */
@RestController // Combina @Controller + @ResponseBody para APIs REST
@RequestMapping("inventario-app") // Ruta base: http://localhost:8080/inventario-app
@CrossOrigin(value = "http://localhost:4200") // Permite peticiones desde Angular (puerto 4200)
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    /**
     * GET - Obtiene todos los productos del inventario
     * @return Lista completa de productos
     */
    @GetMapping("/productos") // GET http://localhost:8080/inventario-app/productos
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    /**
     * POST - Crea un nuevo producto en el inventario
     * @param producto Datos del producto a crear (JSON en el body)
     * @return Producto creado con ID generado
     */
    @PostMapping("/productos") // POST http://localhost:8080/inventario-app/productos
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);
        return this.productoServicio.guardarProducto(producto);
    }

    /**
     * GET - Busca un producto específico por su ID
     * @param id Identificador del producto
     * @return Producto encontrado o excepción 404 si no existe
     */
    @GetMapping("/productos/{id}") // GET http://localhost:8080/inventario-app/productos/1
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto != null){
                return ResponseEntity.ok(producto); // HTTP 200 OK
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id); // HTTP 404
        }
    }

    /**
     * PUT - Actualiza un producto existente
     * @param id ID del producto a actualizar
     * @param productoRecibido Nuevos datos del producto (JSON en el body)
     * @return Producto actualizado
     */
    @PutMapping("/productos/{id}") // PUT http://localhost:8080/inventario-app/productos/1
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoRecibido
    ){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        // Actualiza los campos del producto existente
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setExistencia(productoRecibido.getExistencia());
        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    /**
     * DELETE - Elimina un producto del inventario
     * @param id ID del producto a eliminar
     * @return Confirmación de eliminación exitosa
     */
    @DeleteMapping("/productos/{id}") // DELETE http://localhost:8080/inventario-app/productos/1
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
        this.productoServicio.eliminarProductoPorId(producto.getIdProducto());
        // Respuesta JSON de confirmación
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
