package com.unitbv.labs.tema2springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitbv.labs.tema2springboot.dao.PersonDAO;
import com.unitbv.labs.tema2springboot.entities.Person;

@RestController
public class PersonController {

	@GetMapping("/people/get/{id}")
	public Person getPerson(@PathVariable int id) throws Exception {
		PersonDAO personDAO = new PersonDAO();
		Person person = personDAO.findById(id);
		if (person == null) {
			throw new Exception("Person not found for id " + id);
		}
		return person;
	}

	@DeleteMapping("/people/delete/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable int id) {
		PersonDAO personDAO = new PersonDAO();
		Person person = personDAO.findById(id);
		if (person == null) {
			return ResponseEntity.notFound().build();
		}
		personDAO.delete(person);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/people/add")
	public void createPerson(@RequestBody Person person) {
		PersonDAO personDAO = new PersonDAO();
		personDAO.createOrUpdate(person);
	}

	@PutMapping("/people/update/{id}")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable int id) {

		PersonDAO personDAO = new PersonDAO();
		Person foundPerson = personDAO.findById(id);
		if (foundPerson == null) {
			return ResponseEntity.notFound().build();
		}
		person.setId(id);
		personDAO.update(person);
		return ResponseEntity.noContent().build();
	}
}
