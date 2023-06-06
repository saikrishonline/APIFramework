package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlayPayLoad(String name, String language, String address) {
		
		Location l = new Location();
		AddPlace am = new AddPlace();
		am.setAccuracy(50);
		am.setAddress(address);
		am.setLanguage(language);
		am.setPhoneNumber("(+66) 989 111 000");
		am.setWebsite("https://saiphaniSwetha-academy.com");
		am.setName(name);
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		am.setTypes(list);
		l.setLat(-38.383494);
		l.setLng(33.427362);
		am.setLocation(l);
		
		return am;
		
	}
	
	
}
