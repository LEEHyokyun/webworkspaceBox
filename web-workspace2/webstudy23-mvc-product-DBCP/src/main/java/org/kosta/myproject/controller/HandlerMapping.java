package org.kosta.myproject.controller;

/*
 * client의 요청을 분석하여 실제적으로 controller 객체를 생성하여 return 하는 객체
 * Factory obejct
 */
public class HandlerMapping {
	
	private static HandlerMapping instance = new HandlerMapping();
	//instance return HandlerMapping data type / its object.
	private HandlerMapping() {};
	
	public static HandlerMapping getInstance() {
		return instance;
	}
	
	public Controller create(String controllerName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String packageInfo = this.getClass().getPackage().getName();
		//package name
		String classInfo = new StringBuilder(packageInfo).append(".").append(controllerName).toString();
		//controller object를 생성하기 위한 controller 지정(경로특정)
		Controller controller = (Controller) Class.forName(classInfo).newInstance();
		//최종적으로 (런타임 시점에) 해당 controller 객체를 생성한다.		
		
		return controller;
	}
}
