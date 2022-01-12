package com.mobiquity.responsedto;

import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetailsDTO extends ResponseBase{
	private String userId;
	private String id;
	private String title;
	private String body;
}
