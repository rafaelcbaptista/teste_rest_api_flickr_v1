package br.com.flickr.Testes;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;


public class TestesAPI_JUnit {
	
    public TestesAPI_JUnit(){
        baseURI = "https://api.flickr.com/services";
    }

	@Test
	/*Verifica o status retornado do HTTP. Checa se o status code é 200*/
    public void teste_Codigo_Status_Resposta_200()
    {
        given()
        
        .when()
            .get("")                     
        .then()
            .statusCode(200);
    }    

	@Test
	/*Verifica um login válido*/
    public void teste_APIcomAutenticacaoBasica_Login_Valido()
    {
        given()
        	.auth()
        	.preemptive()
            .basic("valida_api", "Alzm@80")
        .when()
            .get("")                     
        .then()
            .statusCode(200);
    }
	
	@Test
	/*Verifica o Json de login válido*/
    public void teste_APIcomAutenticacaoToken_Json() 
	{
         
         given()
         .when()
            .get("/rest/?method=flickr.test.login&api_key=1a6c20cf1910df63f885f4a0a88d1a92&format=json&nojsoncallback=1&auth_token=72157691541022555-d465e67bd0ecc0fd&api_sig=c7eb835125438c62ba01447f1a06cb12")
         .then()
            .statusCode(200)
            .body("user.id", containsString("158345347@N08"))
            .body("user.username._content", containsString("valida_api"))
            .body("user.path_alias", equalTo(null))
            .body("stat", equalTo("ok"))
         	.assertThat()
         		.body(matchesJsonSchemaInClasspath("json-schema.json"));
            
    }

	
	@Test
	/*Verifica o Modelo da Camera utilizada*/
    public void teste_Modelo_de_Camera() 
	{
         
         given()
         .when()
            .get("/rest/?method=flickr.cameras.getBrandModels&api_key=1a6c20cf1910df63f885f4a0a88d1a92&brand=Sony&format=json&nojsoncallback=1&auth_token=72157691541022555-d465e67bd0ecc0fd&api_sig=c43a42f23b2b2badb2be74100e2bf031")
         .then()
            .statusCode(200)
            .body("cameras.camera[0].name._content", containsString("Sony A6000"))
            .body("stat", equalTo("ok"))
         	.assertThat()
         		.body(matchesJsonSchemaInClasspath("json-schema.json"));
            
    }	
      
}
