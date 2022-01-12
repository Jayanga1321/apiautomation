package com.mobiquity.responsedto;

import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO extends ResponseBase{
	
	private List<CommentDTO> post;

	public void setUser(List<CommentDetailsDTO> asList) {
		// TODO Auto-generated method stub
		
	}
}
