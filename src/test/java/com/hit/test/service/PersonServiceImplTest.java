package com.hit.test.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hit.dto.PersonRequest;
import com.hit.entity.Person;
import com.hit.repository.PersonRepository;
import com.hit.service.PersonService;
import com.hit.utils.enums.MessageEnum.Messages;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class PersonServiceImplTest {
	
	@Inject
	PersonService personService;
	
	@InjectMock
	PersonRepository personRepository;

	@Test
	void addPersonTest() {
		Mockito.doNothing().when(personRepository).persist(any(Person.class));
		assertDoesNotThrow(() -> personService.addPerson(PersonRequest.builder().name("test").age(20).build()));
	}
	
	
	@Test
	void getAllPersonTest() {
		var query = Mockito.mock(PanacheQuery.class);
		Mockito.when(query.list()).thenReturn(List.of(Person.builder().name("test").age(20).build()));
		Mockito.when(personRepository.findAll()).thenReturn(query);
		assertEquals(20, personService.getAllPerson().get(0).getAge());
	}
	
	@Test
	void addPersonRequestTest() {
		ConstraintViolationException error = assertThrows(ConstraintViolationException.class, () -> personService.addPerson(PersonRequest.builder().age(10).build()));
		assertEquals(error.getConstraintViolations().stream().findFirst().get().getMessage(), Messages.NAME_REQUIRED);
		
		error = assertThrows(ConstraintViolationException.class, () -> personService.addPerson(PersonRequest.builder().name("Test").build()));
		assertEquals(error.getConstraintViolations().stream().findFirst().get().getMessage(), Messages.AGE_REQUIRED);
	}
	
}
