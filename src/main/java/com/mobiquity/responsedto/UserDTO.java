package com.mobiquity.responsedto;

import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends ResponseBase{
	
	private List<UserDTO> user;

	public void setUser(List<UserDetailsDTO> asList) {
		// TODO Auto-generated method stub
		
	}
}
