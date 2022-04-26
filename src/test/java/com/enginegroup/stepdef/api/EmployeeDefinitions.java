package com.enginegroup.stepdef.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.equalTo;

public class EmployeeDefinitions {

    private static final String baseUri = "http://dummy.restapiexample.com/api/v1/";
    public Response response;

    @Given("I send a request to endpoint using params {}")
    public void sendGetRequest(String requestParams) {
        response = SerenityRest.given().baseUri(baseUri).contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(requestParams);
    }

    @Given("I send a request to endpoint using params {} and following body content {} {} {}")
    public void sendPostRequest(String requestParams, String user, int sal, int age) {
        response = SerenityRest.given().baseUri(baseUri).contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .body("name:\""+user+"\","+"\"salary:\""+sal+"\","+"\"age:\""+age+"")
                .post(requestParams);
    }

    @Then("The API should return status {int}")
    public void verifyResponse(int status) {
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
    }

    @And("Response should contains employee name {}")
    public void verifyResponseContent(String expectedEmployeeName) {
        SerenityRest.restAssuredThat(response -> response.body("data.employee_name", equalTo(expectedEmployeeName)));
    }
}