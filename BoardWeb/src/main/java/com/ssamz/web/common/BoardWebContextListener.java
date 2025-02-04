package com.ssamz.web.common;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class BoardWebContextListener implements ServletContextListener {

    public BoardWebContextListener() {
    	System.out.println("===> BoardWebContextListener ");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("---> ServletContxt");
    }	
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("---> ServletContxt");
    }
}
