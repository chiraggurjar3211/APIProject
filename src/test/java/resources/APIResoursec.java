package resources;

public enum APIResoursec {
	AddPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
	private String resorces;
	APIResoursec(String resorces){
		this.resorces=resorces;
	}
	public String getResources() {
		return resorces;
	}
	
}
