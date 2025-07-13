import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

/**
 * Componente que muestra la lista de productos en una tabla
 * Permite ver, editar y eliminar productos del inventario
 */
@Component({
  selector: 'app-producto-lista',
  imports: [], // Sin imports adicionales por ahora
  templateUrl: './producto-lista.html',
})
export class ProductoLista {
  // Array que almacena todos los productos para mostrar en la tabla
  productos!: Producto[];

  // Servicio inyectado para operaciones CRUD de productos
  private productoServicio = inject(ProductoService);
  
  // Router inyectado para navegación entre páginas
  private enrutador = inject(Router);

  /**
   * Método del ciclo de vida que se ejecuta al inicializar el componente
   */
  ngOnInit() {
    // Cargar la lista de productos al iniciar
    this.obtenerProductos();
  }

  /**
   * Obtiene todos los productos del servidor y los asigna al array local
   */
  private obtenerProductos(): void {
    this.productoServicio.obtenerProductosLista().subscribe(
      {
        next: (datos) => {
          // Asignar los productos recibidos al array local
          this.productos = datos;
        },
        error: (error) => {
          // Manejar errores de la petición HTTP
          console.error('Error al obtener los productos:', error);
        }
      }
    );
  }

  /**
   * Navega a la página de edición de un producto específico
   * @param id - ID del producto a editar
   */
  editarProducto(id: number){
    this.enrutador.navigate(['editar-producto', id]);
  }

  /**
   * Elimina un producto del inventario y actualiza la lista
   * @param id - ID del producto a eliminar
   */
  eliminarProducto(id: number){
    this.productoServicio.eliminarProducto(id).subscribe({
      next: (datos) => this.obtenerProductos(), // Recargar lista tras eliminar
      error: (errores) => console.log(errores) // Manejar errores
    });
  }

}
