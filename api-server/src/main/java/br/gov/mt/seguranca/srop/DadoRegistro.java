package br.gov.mt.seguranca.srop;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author denyshetzel
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadoRegistro {

	@NotNull
	private Long codigoUnidadeOrganizacional;
	
	private Periodo periodoRegistro;
	
	private Periodo periodoFato;
	
}
