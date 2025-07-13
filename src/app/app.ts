import { Component, signal } from '@angular/core';
import { RouterModule } from '@angular/router';

/**
 * Componente raíz de la aplicación
 * Contiene la estructura principal y el sistema de navegación
 */
@Component({
  selector: 'app-root', // Selector usado en index.html
  templateUrl: './app.html',
  imports: [RouterModule] // Importa RouterModule para navegación
})
export class App {
  // Signal reactivo para el título de la aplicación
  protected readonly title = signal('inventario-app');
}
