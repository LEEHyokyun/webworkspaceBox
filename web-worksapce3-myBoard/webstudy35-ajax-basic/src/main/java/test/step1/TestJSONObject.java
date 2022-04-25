package test.step1;

import org.json.JSONObject;

import model.CarDTO;

public class TestJSONObject {
	public static void main(String[] args) {
		//DTO 또는 VO 를 JSONObject로 생성
		//DTO, Data Transfer Object
		CarDTO dto=new CarDTO("k5",2000,"기아");
		
		JSONObject json=new JSONObject(dto);
		System.out.println(json.toString()); //JSON 형식, map(key:value) 형식으로 출력
		JSONObject json2 = new JSONObject();
		json2.put("id", "javaking");
		json2.put("name", "아이유");
		System.out.println(json2.toString());
	}
}
