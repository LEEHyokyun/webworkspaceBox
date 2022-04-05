package test.unit.reflection;

public class TestAutoCreateInstance {
	public static void main(String[] args) {
		Player player = null;
		
		String classInfo = "test.unit.reflection.Youtube";
		//class loading 및 객체생성(*다운캐스팅)
		try {
			//runtime시 class.forName으로 클래스를 로딩, newInstance로 해당 객체를 생성
			player = (Player) Class.forName(classInfo).newInstance();
			player.play(); //player의 객체 별도 생성없이 해당 player의 play 메소드 사용 가능!
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
