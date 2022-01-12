package com.mobiquity.responsedto;

import com.mobiquity.util.ResponseBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDetailsDTO extends ResponseBase{
	private String postId;
	private String id;
	private String name;
	private String email;
	private String body;
}
