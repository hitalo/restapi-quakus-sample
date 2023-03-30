package com.hit.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.hit.dto.PersonRequest;
import com.hit.dto.PersonResponse;
import com.hit.repository.PersonRepository;
import com.hit.service.PersonService;
import com.hit.utils.mapper.PersonMapper;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class PersonServiceImpl implements PersonService {
	
	@Inject
	PersonRepository personRepository;
	
	@Inject
	PersonMapper personMapper;

	@Override
	@Transactional
	public void addPerson(@Valid PersonRequest personRequest) {
		log.info("[addPerson]");
		personRepository.persist(personMapper.toEntity(personRequest));
	}

	@Override
	public List<PersonResponse> getAllPerson() {
		log.info("[getAllPerson]");
		return personRepository.findAll().list().stream().map(person -> personMapper.toResponse(person)).toList();
	}

}
