package test;

public class TestUnitRedirect {
	public static void main(String[] args) {
		String path = "redirect:registercar-result.jsp";
		System.out.println(path.startsWith("redirect:"));
		System.out.println(path.substring(9));
		//index 9이후, 즉 10부터 문자열을 그대로 출력
	}
}
