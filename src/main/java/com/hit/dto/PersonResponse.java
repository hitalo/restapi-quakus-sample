package com.hit.dto;

import java.io.Serializable;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

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
public class PersonResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Person id", example = "1")
	private Long id;
	
	@Schema(description = "Person name", example = "Paul")
	private String name;
	
	@Schema(description = "Person age", example = "22")
	private Integer age;
}
