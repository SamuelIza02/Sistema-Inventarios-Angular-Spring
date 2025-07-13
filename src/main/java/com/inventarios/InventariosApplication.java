package com.inventarios;

import com.inventarios.modelo.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot para sistema de inventarios
 * Punto de entrada de la aplicación - inicia el servidor embebido Tomcat
 * Configuración automática de Spring Boot con escaneo de componentes
 */
@SpringBootApplication // Combina @Configuration + @EnableAutoConfiguration + @ComponentScan
public class InventariosApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot
	 * Levanta servidor Tomcat en puerto 8080 por defecto
	 * @param args Argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(InventariosApplication.class, args);
		// Aplicación disponible en: http://localhost:8080/inventario-app
	}

}
