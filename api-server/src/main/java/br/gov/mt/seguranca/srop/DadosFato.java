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
public class DadosFato {

	//private PeriodoDTO periodoFatoPeriodo;
	
	private Long codigoMunicipio;
	
	private Long codigoBairro;

}
