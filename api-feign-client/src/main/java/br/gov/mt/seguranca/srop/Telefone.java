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
public class Telefone {

	//@Size(min = 2, max = 3)
	private String ddd;
	
	//@NotEmpty	
	private String numero;
	
}
