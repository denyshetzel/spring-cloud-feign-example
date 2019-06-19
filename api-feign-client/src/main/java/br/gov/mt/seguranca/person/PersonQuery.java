package br.gov.mt.seguranca.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonQuery {

	private String name;
	
	private AddressDTO address;
	
}
