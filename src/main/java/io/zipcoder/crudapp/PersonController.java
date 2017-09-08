package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	//List<Person> personList;
	
	@Autowired
	PersonRepository personRepo;
	
	@RequestMapping(value="/people", method=RequestMethod.POST)
	public ResponseEntity<Person> createPerson(@RequestBody Person p)
	{
		personRepo.save(p);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/people/{id}", method=RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable int id)
	{
		Person p = personRepo.findOne(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value="/people", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Person>> getPersonList()
	{
		Iterable<Person> people = personRepo.findAll();
		return new ResponseEntity<>(people, HttpStatus.OK);
	}
	
	@RequestMapping(value="/people/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Person> updatePerson(@RequestBody Person p)
	{
		personRepo.save(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value="/people/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deletePerson(@PathVariable int id)
	{	
		personRepo.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
