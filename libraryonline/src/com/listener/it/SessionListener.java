package com.listener.it;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         ServletContext application = arg0.getSession().getServletContext();
         Object count = application.getAttribute("count");
         if(count == null){
        	 application.setAttribute("count", 1); 
         } else {
        	 application.setAttribute("count", Integer.parseInt(count.toString()) + 1);
         }
         System.out.println("apply :" + application.getAttribute("count"));
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	 ServletContext application = arg0.getSession().getServletContext();
    	 Object count = application.getAttribute("count");
    	 application.setAttribute("count", Integer.parseInt(count.toString()) - 1);
    	
    }
	
}
