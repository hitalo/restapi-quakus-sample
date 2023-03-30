package com.hit.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

import com.hit.dto.PersonRequest;
import com.hit.dto.PersonResponse;


@ApplicationScoped
public interface PersonService {
	void addPerson(@Valid PersonRequest personRequest);
	List<PersonResponse> getAllPerson();
}
