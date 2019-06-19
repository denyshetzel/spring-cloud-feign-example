package br.gov.mt.seguranca.srop;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
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
@ToString
public class DadoRegistro {

	@NotNull
	private Long codigoUnidadeOrganizacional;
	
	private Periodo periodoRegistroDTO;
	
	private Periodo periodoFatoDTO;
	
}
