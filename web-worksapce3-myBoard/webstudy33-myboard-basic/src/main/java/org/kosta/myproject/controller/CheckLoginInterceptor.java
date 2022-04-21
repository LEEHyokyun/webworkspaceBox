package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 공통인증정책을 체크
 * 인증필요 컨트롤러에 대해 세션이 존재하며, 인증정보 유무를 판단하여 컨트롤러 로직을 이동한다.
 */
public class CheckLoginInterceptor {
	private static CheckLoginInterceptor instance = new CheckLoginInterceptor();
	//인증이 필요없는 컨트롤러 리스트 저장
	private ArrayList<String> permitAllList = new ArrayList<String>();
	
	private CheckLoginInterceptor() {
		permitAllList.add("ListController");
		permitAllList.add("LoginController");
	};

	public static CheckLoginInterceptor getInstance() {
		return instance;
	};
	/*
	 * 로그인이 필요한 컨트롤러에 대한 로직
	 */
	public boolean checkLogin(HttpServletRequest request, String controllerName) {
		//인증정책에 대해 확인
		boolean result = true;
		if(!permitAllList.contains(controllerName)) {
			HttpSession session = request.getSession();
			if(session == null || session.getAttribute("mvo") == null) {
				System.out.println(controllerName+"은 인증이 필요한 서비스입니다.");
				result = false;
			}
		}
		
		return result;
	}
	
}
