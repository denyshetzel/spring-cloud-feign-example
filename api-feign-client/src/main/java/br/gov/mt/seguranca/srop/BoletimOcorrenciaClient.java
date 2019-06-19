package br.gov.mt.seguranca.srop;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8080/api/boletims", name = "boletim-service")
public interface BoletimOcorrenciaClient {
	
	@RequestMapping(method = RequestMethod.GET, value ="/dadosboletim-dois")
	ResponseEntity<DadosBoletim> query(@SpringQueryMap DadosBoletim dadosBoletimDTO);
	
}
