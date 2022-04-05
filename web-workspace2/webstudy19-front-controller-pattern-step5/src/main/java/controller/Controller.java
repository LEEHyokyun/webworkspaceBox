package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * controller logic을 수행하는 개별 컨트롤러를 캡슐화
 */
public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
