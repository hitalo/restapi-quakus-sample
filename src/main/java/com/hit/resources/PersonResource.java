package com.hit.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.hit.dto.MessageResponse;
import com.hit.dto.PersonRequest;
import com.hit.dto.PersonResponse;
import com.hit.service.PersonService;
import com.hit.utils.enums.MessageEnum;

import lombok.extern.slf4j.Slf4j;

@Path("/person")
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class PersonResource {
	
	@Inject
	PersonService personService;

	@GET
	@Path("/hello")
	public String helloPerson() {
		return "Hello Person";
	}
	
	
	@POST
	@Operation(summary = "Save person")
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Success save person", content = @Content(schema = @Schema(implementation = MessageResponse.class ))),
			@APIResponse(responseCode = "400", description = "Validation error", content = @Content(schema = @Schema(implementation = String.class )))
			})
	public Response savePerson(PersonRequest personRequest) {
		log.info("savePerson");
		personService.addPerson(personRequest);

		return Response.ok(MessageResponse.builder()
				.code(MessageEnum.SUCCESS_SAVE_PERSON.getCode())
				.message(MessageEnum.SUCCESS_SAVE_PERSON.getMessage()).build())
				.build();
	}
	
	@GET
	@Operation(summary = "Get all person")
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Success get all person", content = @Content(schema = @Schema(implementation = PersonResponse.class, type = SchemaType.ARRAY )))
			})
	public Response getAllPerson() {
		log.info("getAllPerson");
		return Response.ok(personService.getAllPerson()).build();
	}
}
