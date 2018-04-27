package com.tech.SpringBootSwagger.service;

import java.util.List;

import com.tech.SpringBootSwagger.entity.Person;
/**
 * 
 * @author jasleen.khurana
 *
 */
public interface PersonService {

	public Person getById(Integer id);
	public List<Person> list();
	public int savePerson(Person person);
	public void deletePerson(Integer id);
}
