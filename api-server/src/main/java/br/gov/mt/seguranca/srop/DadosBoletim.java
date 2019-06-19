package br.gov.mt.seguranca.srop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author denyshetzel
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosBoletim {

	private String numeroBoletimOcorrencia;
	
	//private DadosFato dadosFato;
	
	private Envolvido envolvido;
	
}
