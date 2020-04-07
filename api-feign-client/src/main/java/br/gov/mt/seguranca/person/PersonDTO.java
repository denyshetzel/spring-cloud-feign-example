package br.gov.mt.seguranca.person;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonDTO implements Serializable{

	private static final long serialVersionUID = -4753630163637194020L;

	private String name;
	
	private String address;

}
