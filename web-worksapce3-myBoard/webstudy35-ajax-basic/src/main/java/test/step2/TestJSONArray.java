package test.step2;

import java.util.ArrayList;

import org.json.JSONArray;

import model.CarDAO;
import model.CarDTO;

public class TestJSONArray {
	public static void main(String[] args) {
		JSONArray ja = new JSONArray();
		ja.put("apple");
		ja.put("bannana");
		System.out.println(ja.toString()); //Jsonarray, 즉 리스트 형식으로 출력
		ArrayList<CarDTO> list = CarDAO.getInstance().getCarList("현대");
		//DAO로부터 반환받는 리스트를 JSON Array로 생성
		JSONArray ja2 = new JSONArray(list);
		System.out.println(ja2.toString()); //json object가 요소로 구성된 json array
	}
}




