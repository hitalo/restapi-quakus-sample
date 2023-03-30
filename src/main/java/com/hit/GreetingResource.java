package com.hit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.hit.dto.MessageResponse;
import com.hit.utils.enums.MessageEnum;
import com.hit.utils.exceptions.MyCustomException;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
    
    @GET
    @Path("/error")
    @Operation(summary = "Test error")
    @Produces(MediaType.APPLICATION_JSON)
	@APIResponses(value = {
			@APIResponse(responseCode = "400", description = "My custom error exception", content = @Content(schema = @Schema(implementation = MessageResponse.class )))
			})
	public Response error() {
    	// check MyApplicationExceptionHandler for more info
		throw new MyCustomException(MessageResponse.builder()
				.code(MessageEnum.ERROR.getCode()).message(MessageEnum.ERROR.getMessage()).build());
	}
}