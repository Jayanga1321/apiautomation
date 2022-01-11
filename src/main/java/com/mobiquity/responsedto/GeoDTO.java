package com.mobiquity.responsedto;

import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoDTO extends ResponseBase{
	private String lat;
	private String lng;
}
