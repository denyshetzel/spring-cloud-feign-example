package br.gov.mt.seguranca.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PersonClientController {

private static final Logger LOGGER = LoggerFactory.getLogger(PersonClientController.class);
	
	private final PersonClient personClient;
	
	@GetMapping(value = "/query-client")
	public ResponseEntity<PersonDTO> findByQuery(PersonQuery personQuery, Pageable pageable){
		LOGGER.info("call client findByQuery with param PersonQuery: {} e pageable", personQuery, pageable);
		
		return personClient.query(personQuery, pageable);
	}
	
}
