package edu.iupui.cit388.json;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessor {

	public static void main(String[] args) {
		// this is sample 1
//		createJsonFromJavaObject();
		
//		createJavaObjectFromJson();
		
//		createJavaObjectFromJsonV2();
		
		createJavaObjectFromJsonV3();
	}

	private static void createJsonFromJavaObject() {

		try {
			// this allows you to process a json file
			ObjectMapper objectMapper = new ObjectMapper();

			
			Item item1 = new Item();
			item1.setId("101");
			item1.setName("Egg");
			item1.setPrice(2.99);

			Item item2 = new Item();
			item2.setId("102");
			item2.setName("Milk");
			item2.setPrice(3.99);

			Item item3 = new Item();
			item3.setId("103");
			item3.setName("Bread");
			item3.setPrice(1.49);

			Item item4 = new Item();
			item4.setId("104");
			item4.setName("Juice");
			item4.setPrice(4.49);

			Items items = new Items();
			
			items.getItems().add(item1);
			items.getItems().add(item2);
			items.getItems().add(item3);
			items.getItems().add(item4);

			
			// converts the java object to a json string
			objectMapper.writeValue(new File("./resource/items.json"), items);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createJavaObjectFromJson() {

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			Items items = objectMapper.readValue(new File("./resource/items2.json"), Items.class);  

			for (Item item : items.getItems()) {
				System.out.println(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void createJavaObjectFromJsonV2() {

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			List<Item> items = objectMapper.readValue(new File("./resource/items3.json"), new TypeReference<List<Item>>(){});  

			for (Item item : items) {
				System.out.println(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static void createJavaObjectFromJsonV3() {

		try {
			
			ObjectMapper objectMapper = new ObjectMapper();

			Item item = objectMapper.readValue(new File("./resource/items4.json"), Item.class);  

			System.out.println(item);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
