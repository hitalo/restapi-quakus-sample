package com.hit.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.hit.utils.enums.MessageEnum.Messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = Messages.NAME_REQUIRED)
	@Schema(required = true, description = "Person name", example = "John")
	private String name;
	
	@NotNull(message = Messages.AGE_REQUIRED)
	@Schema(required = true, description = "Person age", example = "31")
	private Integer age;
}
