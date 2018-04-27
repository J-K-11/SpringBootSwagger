package com.tech.SpringBootSwagger.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.SpringBootSwagger.entity.Person;
import com.tech.SpringBootSwagger.service.PersonService;
/**
 * 
 * @author jasleen.khurana
 *
 */
@RestController
@Api(value="Person Controller", description="Everything about Person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@ApiOperation(value="Get person by id")
	@RequestMapping(value="/getById", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getById(@ApiParam(required=true, value="Provide person id")@RequestParam("id") Integer id){
		Person person = personService.getById(id);
		if(person!=null)
			return new ResponseEntity<Person>(person, HttpStatus.OK);
		else
			return new ResponseEntity<String>("{\"message\":\"invalid person id\"}", HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Add/update a new person")
	@RequestMapping(value="/savePerson", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<?> savePerson(@RequestBody Person person){
		return new ResponseEntity<String>("{\"message\":\"Person saved successfully with id:"+personService.savePerson(person)+"\"}", HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all persons")
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getAll(){
		
		return new ResponseEntity<List<Person>>((List<Person>) personService.list(), HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Delete person by id")
	@RequestMapping(value="/deletePerson", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@RequestParam("id") Integer id){
		personService.deletePerson(id);
		return new ResponseEntity<String>("{\"message\":\"Person deleted successfully\"}", HttpStatus.OK);
		
	}
}
