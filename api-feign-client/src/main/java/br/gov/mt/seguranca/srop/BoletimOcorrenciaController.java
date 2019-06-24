package br.gov.mt.seguranca.srop;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * @author denyshetzel
 *
 */
@RestController
@RequestMapping(value = "/api/boletims", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BoletimOcorrenciaController /*extends BaseController implements BoletimOcorrenciaAPI */ {

	private final Logger log = LoggerFactory.getLogger(BoletimOcorrenciaController.class);

	private final BoletimOcorrenciaClient boletimOcorrenciaClient; 
	
	@GetMapping(value = "/status")
	public ResponseEntity<String> status() {
		log.info("status");
		
		return ResponseEntity.ok("OK");
	}

	@GetMapping(value = "/dadosboletim-dois")
	public ResponseEntity<DadosBoletim> consultaPorDadosDoBoletimDois(DadosBoletim dadosBoletim) {
		log.info("Consultando por dados do Boletim {} com paginação {}", dadosBoletim);
		
		return boletimOcorrenciaClient.query(dadosBoletim);
		
	}

	@GetMapping(value = "/dadosboletim")
	public ResponseEntity<List<BoletimOcorrencia>> consultaPorDadosDoBoletim(DadosBoletim dadoBoletimDTO,
			Pageable pageable) {
		log.info("Consultando por dados do Boletim {} com paginação {}", dadoBoletimDTO, pageable);

		return ResponseEntity.ok(null);
	}

}
