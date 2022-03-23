package step7;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class TestServletContextListener
 *
 */
public class TestServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     * 웹 어플리케이션 종료시점에 수행 : 백업작업
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("contextDestroyed가 실행되었습니다.");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     * 웹 어플리케이션 시작시점에 한번 호출 : 초기화작업(보안적용)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("contextInitialized가 실행되었습니다.");
    }
	
}
