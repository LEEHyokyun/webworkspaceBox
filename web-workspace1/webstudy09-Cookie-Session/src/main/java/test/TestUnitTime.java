package test;

import java.util.Date;

/*
 * cookie 유효시간 설정
 */
public class TestUnitTime {
	public static void main(String[] args) {
		Date time = new Date();
		System.out.println(time.toString());
		/*
		 * cookie에 시간정보를 저장하기 위해선, 이에 맞게 설정하는 것이 필요하다.
		 */
		String time2 = time.toString().replace(" ","-");
		System.out.println(time2);
	}
}
