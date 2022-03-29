package test.pattern;

public class CompanyDAO {
	//static : class loading 최초 1번 실행되어 meta space에 저장
	//이를 이용하여 클래스 내부에서 단 한번 객체(생성자) 생성, 객체 주소값을 meta space static 변수 영역에 저장
	private static CompanyDAO instance = new CompanyDAO();
	//private : 외부 클래스에서 객체 생성 차단
	private CompanyDAO() {
		System.out.println("Company DAO 객체 생성");
	}
	
	//static은 외부에서 객체생성없이 클래스 로딩만으로 static 메소드를 접근 및 생성가능
	//이 특성을 이용하여 내부에서 한번 만든 객체의 주소값을 반환하여, 외부에서 현 객체를 사용할 수 있게 된다.
	public static CompanyDAO getInstance() {
		return instance;
	}
	
	public void register(String companyInfo) {
		System.out.println("db insert: "+companyInfo);
	}
}
