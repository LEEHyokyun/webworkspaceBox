package test.unit.reflection;

public class TestAutoCreateInstance2 {
	public static void main(String[] args) {
		ReflectionService service = new ReflectionService();
		String command = "Youtube";
		Player player;
		try {
			player = service.create(command);
			player.play();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
