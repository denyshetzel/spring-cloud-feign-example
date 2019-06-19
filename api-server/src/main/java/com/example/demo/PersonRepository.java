package com.example.demo;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

	
	public Collection<PersonDTO> findAll(){
		return Arrays.asList(
				new PersonDTO("Jose", new Address("78075000")),
				new PersonDTO("Maria", new Address("78075000"))
				);
	}
	
}
