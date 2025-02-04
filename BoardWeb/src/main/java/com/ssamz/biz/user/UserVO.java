package com.ssamz.biz.user;



import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import lombok.Data;


@Data
public class UserVO implements HttpSessionBindingListener {
	private String id;
	private String password;
	private String name; 
	private String role;

	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("---> UserVO");
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("---> UserVO");
	}
}
