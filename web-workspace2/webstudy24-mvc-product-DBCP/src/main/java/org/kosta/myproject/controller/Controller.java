package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller 구현체를 위한 인터페이스 > 생산성 및 유지보수성 향상
 * execute, return path(*implements)
 * @author hyokyun
 *
 */
public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
