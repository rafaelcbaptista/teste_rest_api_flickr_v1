package com.steps;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FlickrValidationSteps {
	
	private Response response;
	private RequestSpecification request;
	
	@Before
	public void setUp() {
		RestAssured.baseURI = "https://api.flickr.com/services/rest/?method=flickr.test.login&api_key=647c45c3407c255fcb5e418211b19bc5&format=json&nojsoncallback=1&auth_token=72157689941352871-fd6b0449e0431e00&api_sig=47811ff00201d598b539eb9e3d4e338f";
		//RestAssured.basePath = "";
	}
	
	@Given("^O Endpoint ja esta configurado$")
	public void the_endpoint_is_already_configured() throws Throwable {
		request = RestAssured.given();
	}
	
	@When("^Eu entro com uma URI valida \"([^\"]*)\"$")
	public void i_input_a_valid_URI(String args) throws Throwable {
		response = request.when().get("" + args);
		response.then().log().all();
	}

	@Then("^Eu devo ter o status code \"([^\"]*)\"$")
	public void i_should_have_the_status_code(String statusCode) throws Throwable {
		response.then().statusCode(Integer.parseInt(statusCode));
	}

	@And("^O tipo do conteudo deve estar no formato \"([^\"]*)\"$")
	public void content_type_should_be_in_format(String format) throws Throwable {
		
		if(format.equals("JSON")){
			response.then().assertThat().contentType(ContentType.JSON).and()
			.body(matchesJsonSchemaInClasspath("json-schema.json"));
		}
	}
	
	@And("^O conteudo do body response deve ser igual a$")
	public void the_body_response_content_should_be_matched(DataTable table) throws Throwable {

		List<List<String>> data = table.raw();
		
		for(int i = 1; i < data.size(); i++){
			response.then().assertThat().body(data.get(i).get(0), equalTo(data.get(i).get(1)));
		}	
	}
	
	@When("^Eu entro com uma URI invalida \"([^\"]*)\"$")
	public void i_input_a_invalid_URI(String args) throws Throwable {
		response = request.when().get("" + 1);
		response.then().log().all();
	}
}
