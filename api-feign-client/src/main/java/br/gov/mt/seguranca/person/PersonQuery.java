package br.gov.mt.seguranca.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class PersonQuery {

	private String name;
	
	private AddressQuery address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressQuery getAddress() {
		return address;
	}

	public void setAddress(AddressQuery address) {
		this.address = address;
	}

}
