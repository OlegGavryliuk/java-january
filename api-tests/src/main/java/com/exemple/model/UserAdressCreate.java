package com.exemple.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Data
@Accessors(chain = true)
@Getter
@Setter
@Generated("com.robohorse.robopojogenerator")
public class UserAdressCreate{

	@JsonProperty("number")
	private String number;

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("street")
	private String street;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("userID")
	private String userID;


}