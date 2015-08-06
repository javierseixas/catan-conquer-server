package com.javierseixas.catan;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GivenWhenThenITest {

    @Test public void
    simple_given_when_then_works() {
        given().
                param("firstName", "John").
                param("lastName", "Doe").
        when().
                get("http://b2d.local:4566/hello").
        then().
                statusCode(200).
                body("greeting", equalTo("Hello World"));
    }

/*    @Test public void
    given_when_then_works_with_assert_that_and_and() {
        given().
                param("firstName", "John").
                param("lastName", "Doe").
                when().
                get("/greet").
                then().
                assertThat().
                statusCode(200).
                and().
                body("greeting", equalTo("Greetings John Doe"));
    }

    @Test public void
    given_when_then_works_with_xpath_assertions() {
        given().
                parameters("firstName", "John", "lastName", "Doe").
                when().
                get("/greetXML").
                then().
                body(hasXPath("/greeting/firstName[text()='John']"));
    }

    @Test public void
    given_when_then_works_with_multiple_body_assertions() {
        given().
                parameters("firstName", "John", "lastName", "Doe").
                when().
                get("/greetXML").
                then().
                body(containsString("greeting")).
                body(containsString("John"));
    }*/
}
