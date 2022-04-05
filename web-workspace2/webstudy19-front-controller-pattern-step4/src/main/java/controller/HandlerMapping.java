package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {};
	public static HandlerMapping getInstance() {
		return instance;
	}
	public Controller create(String command) {
		Controller controller = null;
		
		if(command.equals("findCarByNo")) {
			controller = new FindCarByNoController();
		}else if(command.equals("registerCar")) {
			controller = new RegisterCarController();
		}else if(command.equals("findAllCarList")) {
			controller = new FindAllCarListController();
		}
		
		return controller;
	}
}
