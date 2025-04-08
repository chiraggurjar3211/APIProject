package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.SetGoogleData;

public class TestDataBuid {

	public SetGoogleData addPlacePayLoad() {
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
		return google;
	}
	
}
