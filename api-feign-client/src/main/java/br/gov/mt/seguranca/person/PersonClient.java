package br.gov.mt.seguranca.person;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.querymap.BeanQueryMapEncoder;

@FeignClient(url = "http://localhost:8080/api/persons", name = "person-service", configuration = {BeanQueryMapEncoder.class})
public interface PersonClient {
	
	@RequestMapping(method = RequestMethod.GET, value ="/query")
	ResponseEntity<PersonDTO> query(@SpringQueryMap PersonQuery personQuery);
	
}
