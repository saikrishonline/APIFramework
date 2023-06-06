package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;


import org.junit.runner.RunWith;

import pojo.AddPlace;
import pojo.DeletePlace;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@RunWith(Cucumber.class)
public class StepDefination extends Utils {
	ResponseSpecification resSpect;
	RequestSpecification req;
	Response response;
	private static String placeId;
	JsonPath js;
	
	public static String getPlaceId() {
		return placeId;
	}
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		TestDataBuild td = new TestDataBuild();
		AddPlace am = td.addPlayPayLoad(name,language,address);
		//requestSpecification() method is inherited from Utils class
		req = given().spec(requestSpecification()).body(am);

	}

	@When("User calls {string} with {string} HTTP request")
	public void user_calls_with_post_http_request(String resource,String httpMethod) {
		
	//enum class constructor will be called with value of resource
	APIResources resourceAPI = APIResources.valueOf(resource);
	System.out.println("Value of resourceAPI is::"+resourceAPI.getResource());
	
		
		resSpect = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(httpMethod.equalsIgnoreCase("post")) {
			System.out.println("Inside post method:::");
			response = req.when().post(resourceAPI.getResource());
		}
		else if(httpMethod.equalsIgnoreCase("get")) {
			System.out.println("Inside get method:::");
			response = req.when().get(resourceAPI.getResource());
		}
		else if(httpMethod.equalsIgnoreCase("delete")) {
			System.out.println("Inside get method:::");
			response = req.when().delete(resourceAPI.getResource());

		}
	}

	@Then("The API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
			
		int statusCode=int1.intValue();
		assertEquals(response.getStatusCode(), statusCode);
	}
	
	  @And("^\"([^\"]*)\" code in response body is \"([^\"]*)\"$")
	    public void something_code_in_response_body_is_something(String key, String expValue) throws Throwable {
		  
		  //getJsonPath() method is inherited from Utils class
			String statusRes=getJsonPath(response,key);
			System.out.println("Value of "+key+ "is::"+expValue);
			
			assertEquals(statusRes, expValue);
			
	    }

	  @And("verify place_id created maps to {string} using {string}")
	  public void verify_place_id_created_maps_to_using(String expectedName, String resouceName) throws IOException {
		  //create request specitification
		  
		   placeId=getJsonPath(response,"place_id");
		  req = given().spec(requestSpecification()).queryParam("place_id", placeId);
		  
		  user_calls_with_post_http_request(resouceName,"GET");
		  
		  String name=getJsonPath(response,"name");
		  System.out.println("Address name is::"+name);

		  assertEquals(name,expectedName);
	  }
	  
	  
//	  @Then("verify {string} code in response body is {string} using {string}")
//	  public void verify_code_in_response_body_is_using(String statusKey, String statusResult, String resource) throws IOException {
//	      //build the request specification
//		  
//		  DeletePlace dp = new DeletePlace();
//		  dp.setPlace_id(placeId);
//		  
//		  req = given().spec(requestSpecification()).body(dp);
//		  
//		  //calling the method to invoke deleteresourceAPI
//		  user_calls_with_post_http_request(resource,"DELETE");
//		String status = getJsonPath(response,statusKey);
//		  assertEquals(status,statusResult);
//		  
//	  }
	  
	  
	  @Given("Delete place Payload")
	  public void delete_place_payload() throws IOException {
	      // Write code here that turns the phrase above into concrete actions
		  
		  DeletePlace dp = new DeletePlace();
		  dp.setPlace_id(placeId);
		  System.out.println("Printing place_id"+placeId);
		  req = given().spec(requestSpecification()).body(dp);
		  
		  
	  }

}
