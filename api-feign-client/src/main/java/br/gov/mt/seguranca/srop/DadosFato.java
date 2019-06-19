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
public class DadosFato {

	//private PeriodoDTO periodoFatoPeriodoDTO;
	
	private Long codigoMunicipio;
	
	private Long codigoBairro;

}
