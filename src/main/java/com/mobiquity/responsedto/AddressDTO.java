package com.mobiquity.responsedto;

import java.util.List;

import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddressDTO extends ResponseBase{
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private List<GeoDTO> geo;
}
