package stepDefination;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.SetGoogleData;
import resources.APIResoursec;
import resources.TestDataBuid;
import resources.Utils;
import pojo.Location;

public class StepDeination extends Utils{
	RequestSpecification rb;
	ResponseSpecification rsp;
	
	Response res;
	TestDataBuid test = new TestDataBuid();

	@Given("Add place Payload")
	public void add_place_payload() throws FileNotFoundException {
		test.addPlacePayLoad();
		rb=given().spec(requestData()).body(test.addPlacePayLoad()); //.log().all();
	}

	@When("User call {string} with {string} http request")
	public void user_call_with_post_http_request(String string,String string1) throws FileNotFoundException {
		APIResoursec resourceAPI=APIResoursec.valueOf(string);
		System.out.println(resourceAPI.getResources());
		res = rb.when().get("maps/api/place/add/json").then().spec(responseData()).extract().response();
	}

	@Then("API call is sucess with status code {int}")
	public void apu_call_is_sucess_with_status_code(Integer int1) {
		System.out.println(res.statusCode());
		Assert.assertEquals(res.statusCode(), int1);
	}

	@Then("{string} response body is {string}")
	public void response_body_is(String string, String string2) {
		JsonPath jsp = new JsonPath(res.body().asPrettyString());
		System.out.println(jsp.get(string).toString());
		Assert.assertEquals(jsp.get(string).toString(), string2);
	}
}
