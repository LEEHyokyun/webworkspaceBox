package test;

import org.kosta.myproject.model.Pagination;

public class TestPagination {
	public static void main(String[] args) {
		//총 게시글 수 = 7
		Pagination p = new Pagination(7);
		System.out.println(p.getStartRowNumber());
		
		//총 게시글 수 = 22, 현재 페이지 = 2
		p = new Pagination(22, 2);
		System.out.println(p.getNowPage());
		System.out.println(p.getStartRowNumber());
		
		//총 게시글 수 = 22, 현재 페이지 = 4
		p = new Pagination(22, 4);
		System.out.println(p.getNowPage());
		System.out.println(p.getStartRowNumber());
		
		//마지막 번호
		p = new Pagination(22, 5);
		System.out.println(p.getEndRowNumber());
		
		p = new Pagination(22, 3);
		System.out.println(p.getEndRowNumber());
		
		p = new Pagination(22, 4);
		System.out.println(p.getEndRowNumber());
		
		//총 페이지 수 - 총 게시물 개수 - 현재 페이지 
		p = new Pagination(20, 1);
		System.out.println("총 게시판 페이지수 : "+p.getTotalPage());
		p = new Pagination(22, 1);
		System.out.println("총 게시판 페이지수 : "+p.getTotalPage());
		
		//총 페이지 그룹 수 - 총 게시물 개수 / 한 페이지 당 게시물 수
		p = new Pagination(48,1);
		System.out.println("totalPageGroup: "+p.getTotalPageGroup());
		p = new Pagination(22,1);
		System.out.println("totalPageGroup: "+p.getTotalPageGroup());
		
		//현재 페이지가 속한 페이지 그룹 
		p = new Pagination(48, 8);
		System.out.println("nowPageGroup: "+p.getNowPageGroup());
		p = new Pagination(22, 5);
		System.out.println("nowPageGroup: "+p.getNowPageGroup());
		
		//현재 페이지가 속한 페이지 그룹의 시작과 끝번호
		p = new Pagination(48, 8);
		System.out.println("startPageOfPageGroup: "+p.getStartPageOfPageGroup());
		p = new Pagination(22, 3);
		System.out.println("startPageOfPageGroup: "+p.getStartPageOfPageGroup());
		
		//현재 페이지가 속한 페이지 그룹의 시작과 끝번호
		p = new Pagination(48, 8);
		System.out.println("endPageOfPageGroup: "+p.getEndPageOfPageGroup());
		p = new Pagination(22, 3);
		System.out.println("endPageOfPageGroup: "+p.getEndPageOfPageGroup());
		p = new Pagination(48, 9);
		System.out.println("endPageOfPageGroup: "+p.getEndPageOfPageGroup());
		
		//이전 페이지가 존재하는가
		p = new Pagination(22, 3);
		System.out.println("이전 페이지 존재?: "+p.isPreviousPageGroup());
		p = new Pagination(48, 9);
		System.out.println("이전 페이지 존재?: "+p.isPreviousPageGroup());
		p = new Pagination(31, 4);
		System.out.println("이전 페이지 존재?: "+p.isPreviousPageGroup());
		
		//마지막 페이지가 존재하는가
		p = new Pagination(22, 3);
		System.out.println("다음 페이지 존재?: "+p.isNextPageGroup());
		p = new Pagination(48, 9);
		System.out.println("다음 페이지 존재?: "+p.isNextPageGroup());
		p = new Pagination(31, 4);
		System.out.println("다음 페이지 존재?: "+p.isNextPageGroup());
	}
}
