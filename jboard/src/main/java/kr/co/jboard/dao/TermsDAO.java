package kr.co.jboard.dao;

import java.util.List;

import kr.co.jboard.dto.TermsDTD;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class TermsDAO extends DBHelper{
	
	private static final TermsDAO INSTANCE = new TermsDAO();
	public static TermsDAO getInstance() {
		return INSTANCE;
	}
	private TermsDAO() {}
	
	public void insertTerms(TermsDTD dto) {
		
	}
	
	public TermsDTD selectTerms(int no) {
		
		TermsDTD dto = null;
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_TERMS);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new TermsDTD();
				dto.setNo(rs.getInt(1));
				dto.setTerms(rs.getString(2));
				dto.setPrivacy(rs.getString(3));
			}
			
			closeAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<TermsDTD> selectAllTerms() {
		return null;
	}
	
	public void updateTerms(TermsDTD dto) {
		
	}
	
	public void deleteTerms(int no) {
		
	}
}
