package entity;

public class User4 {
	
	private String uid;
	private String name;
	private char gender;
	private int age;
	private String hp;
	private String addr;
	
	// getter/setter
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
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
		return "User4 [uid=" + uid + ", name=" + name + ", gender=" + gender + ", age=" + age + ", hp=" + hp + ", addr="
				+ addr + "]";
	}
	
	

}
