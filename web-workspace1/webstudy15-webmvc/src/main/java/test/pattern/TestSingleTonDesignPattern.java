package test.pattern;

public class TestSingleTonDesignPattern {
	public static void main(String[] args) {
		//CompanyDAO dao = new CompanyDAO(); //정보은닉으로 인한 생성자 생성 불가
		
		//static method를 이용하여 객체 주소값을 return 받아 활용
		CompanyDAO dao1 = CompanyDAO.getInstance();
		System.out.println(dao1);
		
		CompanyDAO dao2 = CompanyDAO.getInstance();
		System.out.println(dao2);
		//dao1, dao2 객체주소값은 동일, 즉 공유.
		
		dao1.register("LG");
		dao2.register("SK");
	}
}
