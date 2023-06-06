package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		StepDefination s = new StepDefination();
		if(StepDefination.getPlaceId()==null){
			System.out.println("PlaceID is null, hence inside beforeScenario method");
		s.add_place_payload_with("SaiV","Th-TH","307 Sathorn house");
		s.user_calls_with_post_http_request("addPlaceAPI", "POST");
		s.verify_place_id_created_maps_to_using("SaiV", "getPlaceAPI");
		}
	}
}
