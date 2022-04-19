package org.kosta.myproject.model;

public class MemberVO {
	private String id;

	public MemberVO(String id) {
		super();
		this.id = id;
	}

	/*
	 * 주석추가
	 */
	@Override
	public String toString() {
		return "MemberVO [id=" + id + "]";
	}

}
