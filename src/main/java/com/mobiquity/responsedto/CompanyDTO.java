package com.mobiquity.responsedto;

import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO extends ResponseBase{
	private String name;
	private String catchPhrase;
	private String bs;
}
