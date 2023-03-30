package com.hit;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import com.hit.utils.enums.MessageEnum;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }
    
    @Test
    public void testErrorEndpoint() {
        given()
          .when().get("/hello/error")
          .then()
             .statusCode(400)
             .body("code", is(MessageEnum.ERROR.getCode()))
             .body("message", is(MessageEnum.ERROR.getMessage()));
    }

}