package com.tech.SpringBootSwagger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.SpringBootSwagger.dao.PersonRepository;
import com.tech.SpringBootSwagger.entity.Person;
import com.tech.SpringBootSwagger.service.PersonService;
/**
 * 
 * @author jasleen.khurana
 *
 */
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person getById(Integer id) {
		return personRepository.getById(id);
	}

	@Override
	public List<Person> list() {
		return personRepository.findAll();
	}

	@Override
	public int savePerson(Person person) {
		return personRepository.save(person).getId();
	}

	@Override
	public void deletePerson(Integer id) {
		personRepository.delete(id);
		
	}
}
