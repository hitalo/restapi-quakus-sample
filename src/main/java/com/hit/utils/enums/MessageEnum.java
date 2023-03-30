package com.hit.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MessageEnum {
	ERROR("error", "Undefined error."),
	SUCCESS_SAVE_PERSON("success-save-person", "Person saved successfully."),
	NAME_REQUIRED("name-is-required", Messages.NAME_REQUIRED),
	AGE_REQUIRED("age-is-required", Messages.AGE_REQUIRED);
	
	private String code;
	private String message;
	
	public class Messages {
		public static final String NAME_REQUIRED = "Name is required";
		public static final String AGE_REQUIRED = "Age is required";
	}
}
