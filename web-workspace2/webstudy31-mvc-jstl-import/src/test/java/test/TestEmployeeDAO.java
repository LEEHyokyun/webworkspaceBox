package test;

import java.util.ArrayList;
import java.util.HashMap;

import org.kosta.myproject.model.EmployeeDAO;
import org.kosta.myproject.model.EmployeeVO;

/**
 * EmployeeDAO unit test
 * @author hyokyun
 *
 */
public class TestEmployeeDAO {
	public static void main(String[] args) {
		try {
			EmployeeDAO dao = EmployeeDAO.getInstance();
			//1. 총사원수 조회
			int totalCount = dao.findEmpTotalCount();
			System.out.println("총사원수: "+totalCount);
			
			//2. 전체 사원 리스트 조회
			ArrayList<EmployeeVO> list = dao.findAllEmployeeList();
			for(EmployeeVO vo:list) {
				System.out.println(vo.toString());
			}
			//3. empno 사원정보 조회
			EmployeeVO vo = dao.findEmployeeByNo("1");
			System.out.println(vo);
			
			//4. 부서별 사원수 통계정보 조회
			ArrayList<HashMap<String, String>> countList = dao.findEmpCountGroupByDept();
			for(int i=0;i<countList.size();i++) {
				HashMap<String, String> map = countList.get(i);
				System.out.println(map.get("dname")); //key : dname, loc, emp_no
			}
 			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
