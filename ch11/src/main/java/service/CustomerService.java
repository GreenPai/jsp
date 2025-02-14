package service;

import java.util.List;

import dao.CustomerDao;
import dto.CustomerDto;

public enum CustomerService {
	
	// enum ¿­°ÅÇü ½Ì±ÛÅæ 
	INSTANCE;
	
	private CustomerDao dao = CustomerDao.getInstance();
	
	public void registerCustomer(CustomerDto dto) {
		dao.insertCustomer(dto);
	}
	public CustomerDto findCustomer(String custId) {
		dao.selectCustomer(custId);
		return null;
	}
	public List<CustomerDto> findAllCustomer() {
		return dao.selectAllCustomer();
	}
	public void modifyCustomer(CustomerDto dto) {
		dao.updateCustomer(dto);
	}
	public void deleteCustomer(CustomerDto dto) {
		dao.deleteCustomer(dto);
	}
}
