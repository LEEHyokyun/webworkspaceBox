package org.kosta.echoproject.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/*
 * Datasource manager, apache tomcat에서 제공하는 dbcp객체를
 * datasource interface로 생성, 관리하는 클래스이다.
 * 
 * 커넥션 객체를 미리 생성하여 저장소(pool)에 저장하고,
 * 커넥션 필요시 이를 대여, 반납하는 형식으로 작동(시스템 작동성능 향상)
 * 
 * 시스템 자체에선 dbcp 하나만 활용, Singleton pattern으로 관리.
 */
public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource dataSource;
	private DataSourceManager() {
		BasicDataSource dbcp = new BasicDataSource(); 
		dbcp.setDriverClassName("oracle.jdbc.OracleDriver");
		dbcp.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dbcp.setUsername("scott");
		dbcp.setPassword("tiger");
		dbcp.setInitialSize(5); //dbcp 생성시점에서 connection pool에 커넥션 객체를 5개 생성
		dbcp.setMaxTotal(25); //최대 커넥션 개수
		this.dataSource = dbcp; //BasicDatasource 객체는 dataSource 인터페이스를 구현
	}; 
	/*
	 * 생성자 최초 실행간 최초 1번 실행, dbcp 생성!
	 */
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getDataSource(){
		return dataSource;
	}
}
