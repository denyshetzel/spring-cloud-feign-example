package br.gov.mt.seguranca.srop;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
public class Periodo {

	@NotNull
	private Date valorInicial;

	@NotNull
	private Date valorFinal;

}
