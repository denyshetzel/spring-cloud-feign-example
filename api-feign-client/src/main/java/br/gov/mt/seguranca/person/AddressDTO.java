package br.gov.mt.seguranca.person;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AddressDTO {

	@Size(min = 9, max = 9)
	@NotNull
	private String zipcode;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
