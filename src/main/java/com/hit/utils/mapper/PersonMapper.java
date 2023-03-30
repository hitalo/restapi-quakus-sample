package com.hit.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hit.dto.PersonRequest;
import com.hit.dto.PersonResponse;
import com.hit.entity.Person;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface PersonMapper {

	Person toEntity(PersonRequest personRequest);
	PersonResponse toResponse(Person person);
	
}
