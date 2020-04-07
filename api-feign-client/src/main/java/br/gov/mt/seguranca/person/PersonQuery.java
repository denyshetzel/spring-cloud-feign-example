package br.gov.mt.seguranca.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonQuery {

	private String name;
	
	private AddressQuery address;
	
}
