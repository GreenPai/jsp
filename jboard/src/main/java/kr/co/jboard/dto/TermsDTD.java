package kr.co.jboard.dto;

public class TermsDTD {
	
	private int no;
	private String terms;
	private String privacy;
	
	//getter/setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	
	//toString
	@Override
	public String toString() {
		return "TermsDTD [no=" + no + ", terms=" + terms + ", privacy=" + privacy + "]";
	}
	
	

}
