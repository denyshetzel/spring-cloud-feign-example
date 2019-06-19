package br.gov.mt.seguranca.srop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author denyshetzel
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DadosBoletim {

	private String numeroBoletimOcorrencia;
	
	//private DadosFatoDTO dadosFato;
	
	private Envolvido envolvido;
	
}
