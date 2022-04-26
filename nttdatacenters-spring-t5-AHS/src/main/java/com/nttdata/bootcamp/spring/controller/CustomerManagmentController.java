package com.nttdata.bootcamp.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.spring.repository.Customer;
import com.nttdata.bootcamp.spring.services.CustomerManagmentServiceI;

@RestController
@RequestMapping("/customers")
public class CustomerManagmentController {

	@Autowired
	CustomerManagmentServiceI customerService;
	
	@GetMapping
	public List<Customer> showAllCustomers(Model model) {
		
		return customerService.searchAllCustomers();
	}
	
	@PostMapping
	public void saveCustomer(final @RequestBody Customer newCustomer) {
		
		customerService.insertNewCustomer(newCustomer);

	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteCustomer(final @PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
	
	@RequestMapping(path = "/customer", method = RequestMethod.POST, consumes = "application/json")
	public List<Customer> searchBy(@RequestBody Customer customer) {

		// Posibilidad de múltiples resultados.
		List<Customer> customersList = new ArrayList<Customer>();

		// Búsqueda por nombre o nombre completo.
		if (customer != null) {

			// Obtención de filtro de búsqueda.
			final String name = customer.getName();
			final String surName1 = customer.getSurName1();
			final String surName2 = customer.getSurName2();
			final String identityDocNumber = customer.getIdentityDocNumber();

			if (StringUtils.hasText(identityDocNumber)) {

				// Búsqueda de cliente único por documento de identidad.
				customer = customerService.searchByIdentityDocNumber(identityDocNumber);
				customersList.add(customer);

			} else if (StringUtils.hasText(name) && (!StringUtils.hasText(surName1) || !StringUtils.hasText(surName2))) {

				// Búsqueda por nombre.
				customersList = customerService.searchByName(name);

			} else if (StringUtils.hasText(name) && StringUtils.hasText(surName1) && StringUtils.hasText(surName2)) {

				// Búsqueda por nombre completo.
				customersList = customerService.searchByFullName(name, surName1, surName2);
			}
		}

		return customersList;
	}
}