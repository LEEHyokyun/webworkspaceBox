package org.kosta238.webstudy17.model;

import java.io.Serializable;

public class MemberVO implements Serializable{
	/*
	 * server가 리로드 및 세션객체가 리로드되어도, WAS에서 세션객체의 data를 내부적으로 유지하기 위한 방안 : Serializable
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private String name;
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MemberVO(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}

	public MemberVO(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
