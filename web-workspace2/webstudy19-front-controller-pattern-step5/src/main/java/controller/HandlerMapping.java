package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {};
	public static HandlerMapping getInstance() {
		return instance;
	}
	public Controller create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Controller controller = null;
		
		//현재 패키지명
		String packageInfo = this.getClass().getPackage().getName();
		String classInfo = packageInfo+"."+command;
		//controller 정보를 통해 동적으로 controller 객체 생성
		controller = (Controller) Class.forName(classInfo).newInstance();
		
		return controller;
		/* 
		 * Controller의 추가변경이 수동적인 경우
		 * if(command.equals("findCarByNo")) { controller = new FindCarByNoController();
		 * }else if(command.equals("registerCar")) { controller = new
		 * RegisterCarController(); }else if(command.equals("findAllCarList")) {
		 * controller = new FindAllCarListController(); }else
		 * if(command.equals("updateCar")) { controller = new UpdateCarController(); }
		 * 
		 * return controller;
		 */
	}
}
