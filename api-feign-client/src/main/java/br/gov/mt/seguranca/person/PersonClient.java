package br.gov.mt.seguranca.person;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8080/api/persons", name = "person-service")
public interface PersonClient {
	
	@GetMapping(value ="/query")
	ResponseEntity<PersonDTO> query(PersonQuery personQuery);
	
}
