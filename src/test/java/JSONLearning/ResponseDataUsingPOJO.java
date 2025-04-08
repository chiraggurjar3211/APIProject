package JSONLearning;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.github.dockerjava.transport.DockerHttpClient.Request;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseDataUsingPOJO {

	public void matrixAPI() {
		RestAssured.baseURI = "http://192.168.27.126";
		String username = "sa";
		String password = "admin";
		String apiName = "leave-balance";
		String url = "get;userid=a1;format=json;";
		LeaveBalanceResponse response = given().log().all().queryParams("action", url).auth().basic(username, password)
				.urlEncodingEnabled(false).when().post("cosec/api.svc/v2/" + apiName).then()// .log().all()
				.assertThat().statusCode(200).extract().as(LeaveBalanceResponse.class);
		LeaveBalance leaveBalance = response.getLeaveBalance().get(1); // Assuming the first record

		System.out.println(leaveBalance.getOpeningBalance());
	}

	public void openNotifyAPI() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "http://api.open-notify.org";
		GetOpenNotify ch = given().log().all().when().get("iss-now.json").then()// .log().all()
				.assertThat().statusCode(200).extract().as(GetOpenNotify.class);
		System.out.println("Get Message :" + ch.getMessage());
		System.out.println("Get latitude :" + ch.getIss_position().getLatitude());

	}
	public void reqresAPI() {
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://reqres.in").addParam("page", "1").build();
		RestAssured.useRelaxedHTTPSValidation();
		
		GetReqresData data = given().spec(req).log().all().when().get("api/users").getBody().as(GetReqresData.class);
		System.out.println("Get Message :" + data.getPage());
		System.out.println("Get Message :" + data.getPer_page());
		System.out.println("Get Message :" + data.getData().size());
		System.out.println("Get Message :" + data.getData().get(3).getAvatar());
		System.out.println("Get Message :" + data.getData().get(3).getLast_name());
		System.out.println("Get text    :" + data.getSupport().getText());
	}
	
	public void googleMap() throws FileNotFoundException {
		SetGoogleData google=new SetGoogleData();
		Location lo=new Location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		google.setLocation(lo);
		google.setAccuracy(50);
		google.setName("Frontline house");
		google.setPhone_number("(+91) 983 893 3937");
		google.setAddress("29, side layout, cohen 09");
		google.setWebsite("http://google.com");
		google.setLanguage("French-IN");
		List<String> typesSets=new ArrayList<String>();
		typesSets.add("shoe park");
		typesSets.add("shop");
		google.setTypes(typesSets);
		PrintStream printS=new PrintStream(new File("APILogging.txt"));
		RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification rb=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addParam("key", "qaclick123").setBody(google)
				.addFilter(RequestLoggingFilter.logRequestTo(printS))
				.addFilter(ResponseLoggingFilter.logResponseTo(printS)).build();
		ResponseSpecification rsp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		String res=given().spec(rb)//.log().all().
		.when().get("maps/api/place/add/json").then().spec(rsp).extract().response().getBody().asPrettyString();
		System.out.println(res);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ResponseDataUsingPOJO a = new ResponseDataUsingPOJO();
		// a.matrixAPI();
		//a.openNotifyAPI();
		//a.reqresAPI();
		a.googleMap();
	}

}
