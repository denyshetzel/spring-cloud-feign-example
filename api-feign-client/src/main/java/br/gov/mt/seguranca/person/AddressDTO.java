package br.gov.mt.seguranca.person;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	@Size(min = 9, max = 9)
	@NotNull
	private String zipcode;
	
}
