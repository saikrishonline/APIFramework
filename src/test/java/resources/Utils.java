package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification reqSpec;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		 
		
		if(reqSpec==null) {
			PrintStream streamLog= new PrintStream(new FileOutputStream("log.txt"));
		
		
		reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
				.addFilter(RequestLoggingFilter.logRequestTo(streamLog))
				.addFilter(ResponseLoggingFilter.logResponseTo(streamLog))
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		return reqSpec;
		}
		return reqSpec;
		
	}
	
	
	public static String getGlobalValue(String key) throws IOException {
		
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Shailesh Reddy\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		property.load(fis);
		String value=property.getProperty(key);
		return value;
	}
	
	public String getJsonPath(Response response, String key) {
		
	String resp=response.asString();
	JsonPath js=new JsonPath(resp);
	return js.get(key).toString();
	
	}	
}