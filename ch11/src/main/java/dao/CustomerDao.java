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
	
	//�ΰ� ����
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
			// �ý��� ���� �� ������Ʈ Ȱ���ϱ� ���� ���� ������ �α�
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
