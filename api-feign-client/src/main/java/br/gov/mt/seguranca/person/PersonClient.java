package br.gov.mt.seguranca.person;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8080/api/persons", name = "person-service")
public interface PersonClient {
	
	//@GetMapping(value ="/query")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	ResponseEntity<PersonDTO> query(@SpringQueryMap PersonQuery personQuery, Pageable pageable);
	
}
