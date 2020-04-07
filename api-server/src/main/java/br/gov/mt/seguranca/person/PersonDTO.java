package br.gov.mt.seguranca.person;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonDTO implements Serializable{
	
	private static final long serialVersionUID = -4753630163637194020L;

	private String name;
	
	private AddressDTO address;

	

}
