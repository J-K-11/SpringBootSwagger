package com.tech.SpringBootSwagger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tech.SpringBootSwagger.entity.Person;
/**
 * 
 * @author jasleen.khurana
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, PagingAndSortingRepository<Person, Integer>{

	public Person getById(Integer id);

	
}
