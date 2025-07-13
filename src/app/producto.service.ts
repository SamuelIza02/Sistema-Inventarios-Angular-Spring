import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from './producto';

/**
 * Servicio para manejar operaciones CRUD de productos
 * Se comunica con el backend REST API
 */
@Injectable({
  providedIn: 'root' // Disponible en toda la aplicación
})
export class ProductoService {

  // URL base del API REST del backend
  private urlBase = "http://localhost:8080/inventario-app/productos";
  
  // Cliente HTTP inyectado para realizar peticiones
  private clienteHttp = inject(HttpClient);

  /**
   * Obtiene la lista completa de productos
   * @returns Observable con array de productos
   */
  obtenerProductosLista(): Observable<Producto[]> {
    return this.clienteHttp.get<Producto[]>(this.urlBase);
  }

  /**
   * Agrega un nuevo producto al inventario
   * @param producto - Objeto producto a agregar
   * @returns Observable con la respuesta del servidor
   */
  agregarProducto(producto: Producto): Observable<Object>{
    return this.clienteHttp.post(this.urlBase, producto);
  }

  /**
   * Obtiene un producto específico por su ID
   * @param id - ID del producto a buscar
   * @returns Observable con el producto encontrado
   */
  obtenerProductoPorId(id: number): Observable<Producto>{
    return this.clienteHttp.get<Producto>(`${this.urlBase}/${id}`);
  }

  /**
   * Actualiza un producto existente
   * @param id - ID del producto a actualizar
   * @param producto - Datos actualizados del producto
   * @returns Observable con la respuesta del servidor
   */
  editarProducto(id: number, producto: Producto): Observable<Object>{
    return this.clienteHttp.put(`${this.urlBase}/${id}`, producto);
  }

  /**
   * Elimina un producto del inventario
   * @param id - ID del producto a eliminar
   * @returns Observable con la respuesta del servidor
   */
  eliminarProducto(id: number): Observable<Object>{
    return this.clienteHttp.delete(`${this.urlBase}/${id}`);
  }
}
