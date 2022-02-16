package main.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Column(name = "street_name", length = 50)
	private String street;
	@Column(name = "city_name", length = 50)
	private String city;
	@Column(name = "state_name")
	private String state;
	@Column(name = "pin_code")
	private int pincode;

}
