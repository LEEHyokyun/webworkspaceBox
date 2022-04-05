package test.unit.reflection;

public class ReflectionService {
	public Player create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Player player = null;
		
		String packageInfo = this.getClass().getPackage().getName();
		System.out.println("현재 실행중인 서비스의 경로: "+packageInfo);
		
		player = (Player) Class.forName(packageInfo+"."+command).newInstance();
		
		return player;
	}
}
