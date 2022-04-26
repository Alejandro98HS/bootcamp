package com.nttdata.bootcamp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Formación - Spring - Taller 3
 * 
 * Repositorio
 * 
 * @author NTT Data Sevilla
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	/**
	 * Obtención del cliente mediante el nombre.
	 * 
	 * @param name
	 * @return List<Customer>
	 */
	public List<Customer> findByName(final String name);

	/**
	 * Obtención del cliente mediante el nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<Customer>
	 */
	public List<Customer> findByNameAndSurName1AndSurName2(final String name, final String surname1, final String surname2);
	
	public Customer findByIdentityDocNumber(final String dni);

}