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
public class UserCardCreate{

	@JsonProperty("expires")
	private String expires;

	@JsonProperty("longNum")
	private String longNum;

	@JsonProperty("ccv")
	private String ccv;

	@JsonProperty("userID")
	private String userID;


}