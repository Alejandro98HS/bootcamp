package com.nttdata.bootcamp.spring.services;

import java.util.List;

import com.nttdata.bootcamp.spring.repository.Customer;

/**
 * Formación - Spring - Taller 3
 * 
 * Servicio
 * 
 * @author NTT Data Sevilla
 *
 */
public interface CustomerManagmentServiceI {

	/**
	 * Añade un nuevo cliente.
	 * 
	 * @param newCustomer
	 * @return Customer
	 */
	public Customer insertNewCustomer(final Customer newCustomer);

	/**
	 * Consulta todos los clientes.
	 */
	public List<Customer> searchAllCustomers();

	/**
	 * Búsqueda por nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 */
	public List<Customer> searchByFullName(final String name, final String surname1, final String surname2);

	/**
	 * Búsqueda por nombre.
	 * 
	 * @param name
	 */
	public List<Customer> searchByName(final String name);
	
	/**
	 * Busqueda por DNI
	 * 
	 * @param dni
	 * @return
	 */
	public Customer searchByIdentityDocNumber(final String dni);
	
	/**
	 * Borra el cliente dado por la id
	 * 
	 * @param id
	 * @return
	 */
	public void deleteCustomer(final long id);

}