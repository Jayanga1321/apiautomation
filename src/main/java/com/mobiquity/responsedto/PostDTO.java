package com.mobiquity.responsedto;

import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO extends ResponseBase{
	
	private List<PostDTO> post;

	public void setUser(List<PostDetailsDTO> asList) {
		// TODO Auto-generated method stub
		
	}
}
