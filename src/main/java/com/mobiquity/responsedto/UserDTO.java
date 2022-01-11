package com.mobiquity.responsedto;

import java.util.List;

import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends ResponseBase{
	private String id;
	private String name;
	private String username;
	private String email;
	private List<AddressDTO> address;
	private String phone;
	private String website;
	private List<CompanyDTO> company;
}
