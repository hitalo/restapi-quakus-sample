package com.hit.test.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hit.dto.PersonRequest;
import com.hit.dto.PersonResponse;
import com.hit.service.PersonService;
import com.hit.utils.enums.MessageEnum;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;

@QuarkusTest
public class PersonResourceTest {
	
	@InjectMock
	PersonService personService;
	
	
	@Test
	void savePersonTest_ShouldSucced() {
		Mockito.doNothing().when(personService).addPerson(any());
		
		given()
		.contentType(ContentType.JSON)
		.body(new PersonRequest())
		.when().post("/person")
		.then()
			.statusCode(200)
			.body("code", is(MessageEnum.SUCCESS_SAVE_PERSON.getCode()));
	}
	
	@Test
	void getAllPersonTest__ShouldSucced() {
		Mockito.when(personService.getAllPerson()).thenReturn(List.of(PersonResponse.builder().age(31).build()));
		
		var getAllPersonResponse = given().when().get("/person").then().extract().response();
		assertEquals(200,  getAllPersonResponse.statusCode());
	}
}
