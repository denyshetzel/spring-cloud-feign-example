package br.gov.mt.seguranca.person;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressQuery implements Serializable{

	private static final long serialVersionUID = -6334673614988380358L;
	
	@Size(min = 9, max = 9)
	@NotNull
	private String zipcode;
	
}
