package entity;

public class User5 {
	private int seq;
	private String name;
	private char gender;
	private int age;
	private String addr;
	
	// getter/setter
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	// toString
	@Override
	public String toString() {
		return "User5 [seq=" + seq + ", name=" + name + ", gender=" + gender + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
	
	
	
	
}
