package org.kosta.webstudy21.model;

import java.util.ArrayList;

public class MockDAO {
	private static MockDAO instance = new MockDAO();
	private MockDAO() {};
	public static MockDAO getInstance() {
		return instance;
	}
	
	public String findCustomer(String customerId) {
		if(customerId.equals("java"))
			return "아이유 오리";
		return null;
	}
	
	public ArrayList<String> findAllCustomerList(){
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("아이유");
		list.add("박보검");
		list.add("강하늘");
		
		return list;
	}
	
	public void register(String customerInfo) {
		System.out.println("db에 "+customerInfo+"정보를 저장하였습니다.");
	}
}
