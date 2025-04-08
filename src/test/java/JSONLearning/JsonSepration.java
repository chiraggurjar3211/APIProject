package JSONLearning;

import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;

public class JsonSepration {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		String a="{ \r\n"
				+ "  \"accounting\" : [   \r\n"
				+ "                     { \"firstName\" : \"John\",  \r\n"
				+ "                       \"lastName\"  : \"Doe\",\r\n"
				+ "                       \"age\"       : 23 },\r\n"
				+ "\r\n"
				+ "                     { \"firstName\" : \"Mary\",  \r\n"
				+ "                       \"lastName\"  : \"Smith\",\r\n"
				+ "                        \"age\"      : 32 }\r\n"
				+ "                 ],                            \r\n"
				+ "  \"sales\"      : [ \r\n"
				+ "                     { \"firstName\" : \"Sally\", \r\n"
				+ "                       \"lastName\"  : \"Green\",\r\n"
				+ "                        \"age\"      : 27 },\r\n"
				+ "\r\n"
				+ "                     { \"firstName\" : \"Jim\",   \r\n"
				+ "                       \"lastName\"  : \"Galley\",\r\n"
				+ "                       \"age\"       : 41 }\r\n"
				+ "                 ] \r\n"
				+ "} ";
		
		JsonPath js=new JsonPath(a);
		//total count of sales
		int count=js.getInt("sales.size()");
		System.out.println(count);
		String sales=js.get("sales[0].lastName");
		System.out.println(sales);
		for(int i=0;i<count;i++) {
			String firstName=js.get("sales["+i+"].firstName");
			System.out.println(firstName);
			String lastName=js.get("sales["+i+"].lastName");
			System.out.println(lastName);
			int age=js.get("sales["+i+"].age");
			System.out.println(age);
		}
		
		
		ObjectMapper map=new ObjectMapper();
		Map<Object, List<Map<String, String>>> data=map.readValue(a, new TypeReference<Map<Object, List<Map<String, String>>>>() {
		});
		//direct call using Objectmapper
		System.out.println(data.get("sales"));
//		System.out.println(data.get("sales").getFirst().get("age"));
		
		//using jsonNode
		JsonNode node=map.readTree(a);
		//System.out.println(node.get("accounting").get(0));
		for(int x=0;x<node.get("accounting").size();x++) {
			String da=node.get("accounting").get(x).toString();
			System.out.println(da);
			
		}
		
	}

}
