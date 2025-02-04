package com.ssamz.web.common;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class BoardWebSessionListener implements HttpSessionAttributeListener {

	public BoardWebSessionListener() {
		System.out.println("===> BoardWebSessionListener ");
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("---> ");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("---> ");
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("---> ");
	}
}
