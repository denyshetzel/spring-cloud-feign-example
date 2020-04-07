package br.gov.mt.seguranca.person;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

	
	public Collection<PersonDTO> findAll(){
		return Arrays.asList(
				new PersonDTO("Jose", new AddressDTO("78000000")),
				new PersonDTO("Maria", new AddressDTO("78000001"))
				);
	}
	
}
