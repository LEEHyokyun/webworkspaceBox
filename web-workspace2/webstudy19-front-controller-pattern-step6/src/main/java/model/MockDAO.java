package model;
//for test

import java.util.ArrayList;

public class MockDAO {
	private static MockDAO instance = new MockDAO();
	private MockDAO() {};
	public static MockDAO getInstance() {
		return instance;
	}
	public String findCarByNo(String carNo) throws Exception{
		String car = null;
		if(carNo.equals("1234"))
			car = "캐스퍼 검정";
		return car;
	}
	
	public void register(String carInfo) throws Exception{
		System.out.println("db에 "+carInfo+" 차량정보 등록합니다.");
	}
	
	public ArrayList<String> findAllCarList() throws Exception{
		ArrayList<String> list = new ArrayList();
		list.add("현대자동차");
		list.add("기아자동차");
		
		return list;
	}
	
	public void updateCar(String carInfo) throws Exception{
		System.out.println(carInfo+"에 해당하는 정보가 업데이트 되었습니다.");
	}
	
	public void deleteCar(String carNo) throws Exception{
		System.out.println(carNo+"번호에 해당하는 차량정보가 삭제되었습니다.");
	}
}
