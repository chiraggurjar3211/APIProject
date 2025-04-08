package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	RequestSpecification req;
	ResponseSpecification rsp;
	
	public RequestSpecification requestData() throws FileNotFoundException {
		RestAssured.useRelaxedHTTPSValidation();
		PrintStream printS = new PrintStream(new File("APILogging.txt"));
		req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(printS))
				.addFilter(ResponseLoggingFilter.logResponseTo(printS)).build();
		return req;
	}
	
	public ResponseSpecification responseData() {
		rsp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return rsp;
	}
	
}
