package org.jsp.shoppingcartapi.dto;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmailConfiguration {
	private String subject;
	private String text;
	private Map<String, String> user;
}
