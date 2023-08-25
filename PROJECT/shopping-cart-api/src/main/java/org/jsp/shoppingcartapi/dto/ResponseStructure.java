package org.jsp.shoppingcartapi.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private int statusCode;
	private String message;
}
