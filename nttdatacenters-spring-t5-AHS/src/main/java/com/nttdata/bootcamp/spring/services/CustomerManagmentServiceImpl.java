package com.nttdata.bootcamp.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.spring.repository.Customer;
import com.nttdata.bootcamp.spring.repository.CustomerRepository;

/**
 * Formación - Spring - Taller 3
 * 
 * Servicio
 * 
 * @author NTT Data Sevilla
 *
 */
@Service
public class CustomerManagmentServiceImpl implements CustomerManagmentServiceI {

	/** Repositorio - Tabla: T_CUSTOMER */
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer insertNewCustomer(Customer newCustomer) {

		// Verificación de nulidad.
		if (newCustomer != null && newCustomer.getId() == null) {

			// Insercción de cliente.
			newCustomer = customerRepository.save(newCustomer);
		}

		return newCustomer;
	}

	@Override
	public List<Customer> searchAllCustomers() {

		// Consulta clientes.
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> searchByFullName(final String name, final String surname1, final String surname2) {

		// Obtención del listado de clientes por nombre completo.
		return customerRepository.findByNameAndSurName1AndSurName2(name, surname1, surname2);

	}

	@Override
	public List<Customer> searchByName(final String name) {

		// Obtención del listado de clientes por nombre.
		return customerRepository.findByName(name);
	}
	
	@Override
	public Customer searchByIdentityDocNumber(final String dni){
		
		return customerRepository.findByIdentityDocNumber(dni);
	}

	@Override
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

}
