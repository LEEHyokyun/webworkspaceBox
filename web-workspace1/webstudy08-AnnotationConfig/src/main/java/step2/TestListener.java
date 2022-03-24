package step2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener {

    public TestListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("application destroyed");
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	event.getServletContext().setAttribute("commonInfo","ServletContext");
         System.out.println("application initialized");
    }
	
}
