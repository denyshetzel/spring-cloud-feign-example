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
public class AddressDTO implements Serializable{

	private static final long serialVersionUID = -6334673614988380358L;
	
	@Size(min = 9, max = 9)
	@NotNull
	private String zipcode;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDTO other = (AddressDTO) obj;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
}
