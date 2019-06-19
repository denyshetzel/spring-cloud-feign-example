package br.gov.mt.seguranca.srop;

import lombok.Data;

/**
 * @author denyshetzel
 *
 */
@Data
public class Telefone {

	//@Size(min = 2, max = 3)
	private String ddd;
	
	//@NotEmpty	
	private String numero;
	
}
