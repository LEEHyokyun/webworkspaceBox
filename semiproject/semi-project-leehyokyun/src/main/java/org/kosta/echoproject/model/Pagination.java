package org.kosta.echoproject.model;

public class Pagination {
	/*
	 * 현재 페이지
	 */
	private int nowPage = 1;
	/*
	 * 페이지당 게시물수
	 */
	private int postCountPage = 5;
	/*
	 * 페이지 그룹당 페이지 수
	 */
	private int pageCountPerPageGroup = 4;
	/*
	 * 총게시물수(DB에 저장된 총 게시글 수)
	 */
	private int totalPostCount;
	
	public Pagination(int totalPostCount) {
		this.totalPostCount = totalPostCount;
	}
	
	public Pagination(int totalPostCount, int nowPage) {
		this.totalPostCount = totalPostCount;
		this.nowPage = nowPage;
	}
	
	public int getNowPage() {
		return nowPage;
	}
	/**
	 * now Page에서의 게시글 시작 번호 <br>
	 * = 이전 페이지 마지막 번호의 +1 <br>
	 * 페이지 번호 클릭 > ListController에서 페이지 번호 전달 <br> 
	 * BoardDAO에서 총 게시물수 전달 <br>
	 * Pagination 객체 생성 및 현 페이지에 맞는 게시물 리스트 전달 <br>
	 * @return startRowNumber
	 */
	public int getStartRowNumber() {
		//이전 페이지의 마지막 번호 + 1
		return (this.nowPage-1)*this.postCountPage+1;
	}
	
	/**
	 * now Page에서의 게시글 마지막 번호 <br>
	 * 현재 페이지에서 * post 개수 <br>
	 * 단, 마지막 페이지일 경우 post가 채워지지 않을 경우 전체 게시글 수로 지정 <br>
	 * @return
	 */
	public int getEndRowNumber() {
		int finalIndex = this.nowPage*this.postCountPage;
		
		if(finalIndex > this.totalPostCount)
			finalIndex = this.totalPostCount;
		
		return finalIndex;
	}
	
	
	/**
	 * 총 페이지 수 반환 <br>
	 * totalPostCount / postCountPerPage 나머지가 0일 경우 - 몫
	 * totalPostCount / postCountPerPage 나머지가 0이 아닐 경우 - 몫 + 1
	 * @return totalPage
	 */
	public int getTotalPage() {
		int totalPage = totalPostCount/postCountPage;
		if(totalPostCount%postCountPage != 0)
			totalPage = totalPage + 1;
		
		return totalPage;
	}
	
	/**
	 * 총 페이지 그룹수 반환 <br>
	 * getTotalPage() / pageCountPerPageGroup <br>
	 * 나머지가 0 > 그대로 <br>
	 * 나머지가 0이 아니면 > 몫 + 1 <br>
	 * 
	 * 지금 선택한 페이지에 따른 "화면에 출력되는 페이지 그룹" <br>
	 * 총 게시물 수가 48개일때, 페이지 수는 1-2-3-4-....-10까지 존재. <br>
	 * 현재 페이지에 따른 페이지 그룹은, 4개씩(1-2-3-4) 총 3group 존재. <br>
	 * @return totalPageGroup
	 */
	public int getTotalPageGroup() {
		int totalPageGroup = getTotalPage()/pageCountPerPageGroup;
		if(getTotalPage()%pageCountPerPageGroup != 0)
			totalPageGroup = totalPageGroup + 1;
		
		return totalPageGroup;
	}
	
	/**
	 * 현재 페이지가 속한 페이지 그룹 <br>
	 * 현재 페이지가 7page이고, page가 1 2 3 4 5 6 7로 있을때 페이지 그룹은 1group, 2group <br>
	 * nowPage / pageCountPerGroup 
	 * 나머지가 0 > 그대로
	 * 나머지가 0이 아닐 경우 > +1
	 * @return nowPage
	 */
	public int getNowPageGroup() {
		int nowPageGroup = nowPage/pageCountPerPageGroup;
		if(nowPage%pageCountPerPageGroup != 0)
			nowPageGroup = nowPageGroup + 1;
		
		return nowPageGroup;
	}
	
	/**
	 * 현재 페이지 그룹에서의 시작 번호 <br>
	 * nowPage = 6 <br>
	 * 현재 페이지 그룹이 2group, 이전 1group - 1,2,3,4이므로 시작번호는 5 <br>
	 * @return startPage
	 */
	public int getStartPageOfPageGroup() {
		return (getNowPageGroup()-1)*pageCountPerPageGroup+1;
	}
	
	/**
	 * 현재 페이지 그룹에서의 마지막 번호 <br>
	 * nowPage = 6 <br>
	 * 현재 페이지 그룹 * 그룹당 페이지수, 즉 그룹에서의 마지막 번호는 사실상 정해져 있다. <br>
	 * 단, 마지막 번호의 경우 getTotalPage() 값보다 크다면 getTotalPage()가 그대로 마지막 번호가 된다.
	 * @return endPage
	 */
	public int getEndPageOfPageGroup() {
		int endPage = getNowPageGroup()*pageCountPerPageGroup;
		if(endPage > getTotalPage())
			endPage = getTotalPage();
		
		return endPage;
	}
	
	/**
	 * 이전의 페이지 그룹이 존재하는가 <br>
	 * getNowPageGroup()이 1보다 크면(초과) <br>
	 * 이전 페이지 그룹이 존재, 아닐 경우엔 현재 페이지 그룹이 1이므로 이전 페이지 그룹은 존재하지 않는다. <br>
	 * @return flag
	 */
	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if(getNowPageGroup() > 1)
			flag = true;
		
		return flag;
	}
	
	/**
	 * 다음의 페이지 그룹이 존재하는가
	 * getTotalPageGroup() 보다 현재 페이지 그룹이 작을 경우에만 존재한다.
	 * @return flag
	 */
	public boolean isNextPageGroup() {
		boolean flag = false;
		if(getTotalPageGroup()>getNowPageGroup())
			flag = true;
		
		return flag;
	}
}
