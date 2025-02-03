package sub1;

import java.io.IOException;

import jakarta.servlet.jsp.JspWriter;

public class School {
	private String name;
	private int Level;
	private String Schoolname;
	
	// 생성자
	public School(String name, int level, String schoolname) {
		super();
		this.name = name;
		Level = level;
		Schoolname = schoolname;
	}
	
	// 메서드
	public void show(JspWriter out) throws IOException {
		out.println("<p>" + "name: " + name + " Level: " + Level + " Schoolname: " + Schoolname   + " </p>");
	}
	
	
}
