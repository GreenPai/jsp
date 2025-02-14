package dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.CustomerDto;
import util.DBHelper;
import util.SQL;

public class CustomerDao extends DBHelper{
	
	private static final CustomerDao INSTANCE  = new CustomerDao();
	
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	
	//로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private CustomerDao() {}
	
	public void insertCustomer(CustomerDto dto) {
		try {
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_USER1);
			psmt.setString(1, dto.getCustId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddr());
			psmt.executeUpdate();
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
			// 시스템 개선 및 업데이트 활용하기 위해 에러 내용을 로깅
			logger.error(e.getMessage());
		}
	}
	
	public CustomerDto selectCustomer(String custid) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<CustomerDto> selectAllCustomer() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateCustomer(CustomerDto dto) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(CustomerDto dto) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
