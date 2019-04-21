package edu.iupui.cit388.json;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessor {

	public static void main(String[] args) {
		createJsonFromJavaObject();
		
		createJavaObjectFromJson();
	}

	private static void createJsonFromJavaObject() {

		try {
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

			Items items = new Items();
			items.getItems().add(item1);
			items.getItems().add(item2);
			items.getItems().add(item3);

			objectMapper.writeValue(new File("./resource/items.json"), items);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createJavaObjectFromJson() {

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			Items items = objectMapper.readValue(new File("./resource/items.json"), Items.class);  

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

			List<Item> items = objectMapper.readValue(new File("./resource/items.json"), new TypeReference<List<Item>>(){});  

			for (Item item : items) {
				System.out.println(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
