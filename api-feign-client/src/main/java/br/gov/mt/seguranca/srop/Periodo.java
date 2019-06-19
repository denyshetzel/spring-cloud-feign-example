package br.gov.mt.seguranca.srop;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
public class Periodo {

	@NotNull
	private Date valorInicial;

	@NotNull
	private Date valorFinal;

}
