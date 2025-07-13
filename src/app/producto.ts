/**
 * Modelo que representa un producto en el inventario
 * Define la estructura de datos para los productos
 */
export class Producto {
  // Identificador único del producto
  idProducto!: number;
  
  // Descripción o nombre del producto
  descripcion!: string;
  
  // Precio unitario del producto
  precio!: number;
  
  // Cantidad disponible en inventario
  existencia!: number;
}
