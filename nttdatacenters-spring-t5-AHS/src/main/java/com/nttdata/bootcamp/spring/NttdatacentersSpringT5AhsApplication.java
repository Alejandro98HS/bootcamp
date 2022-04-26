package com.nttdata.bootcamp.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.nttdata.bootcamp.spring.repository.Customer;
import com.nttdata.bootcamp.spring.services.CustomerManagmentServiceI;

/**
 * Formación - Spring - Taller 3
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */

@EnableEurekaClient
@SpringBootApplication
public class NttdatacentersSpringT5AhsApplication implements CommandLineRunner {

	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagmentServiceI customerService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT5AhsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("----- NTT DATA SYS - INI -----");
 
		// Nuevos clientes.
		final Customer newCustomer1 = new Customer();
		newCustomer1.setName("Alejandro");
		newCustomer1.setSurName1("Téllez");
		newCustomer1.setSurName2("Rubio");
		newCustomer1.setIdentityDocNumber("28999666A");
		customerService.insertNewCustomer(newCustomer1);

		final Customer newCustomer2 = new Customer();
		newCustomer2.setName("Alejandro");
		newCustomer2.setSurName1("Brazo");
		newCustomer2.setSurName2("Luque");
		newCustomer2.setIdentityDocNumber("30111555B");
		customerService.insertNewCustomer(newCustomer2);

		final Customer newCustomer3 = new Customer();
		newCustomer3.setName("Estefanía");
		newCustomer3.setSurName1("Cano");
		newCustomer3.setSurName2("Muñiz");
		newCustomer3.setIdentityDocNumber("27000888C");
		customerService.insertNewCustomer(newCustomer3);

		System.out.println("----- INICIO TODOS LOS CLIENTES -----");

		// Muestra todos los clientes.
		customerService.searchAllCustomers();

		System.out.println("----- FIN TODOS LOS CLIENTES -----");

		System.out.println("----- INICIO TODOS LOS CLIENTES POR NOMBRE -----");

		// Obtiene los clientes por nombre.
		customerService.searchByName("Alejandro");

		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE -----");

		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE Y APELLIDOS -----");

		// Obtiene los clientes por nombre y apellidos.
		customerService.searchByFullName("Alejandro", "Téllez", "Rubio");

		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE Y APELLIDOS -----");

		System.out.println("----- NTT DATA SYS - FIN -----");
	}

}
