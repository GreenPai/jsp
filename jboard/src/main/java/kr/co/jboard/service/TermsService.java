package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.ArticleDAO;
import kr.co.jboard.dao.TermsDAO;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.TermsDTD;

public enum TermsService {

	INSTANCE;
	private TermsDAO dao = TermsDAO.getInstance();
	
	public void registerTerms(TermsDTD dto) {
		dao.insertTerms(dto);;
	}
	
	public TermsDTD findTerms(int no) {
		return dao.selectTerms(no);
	}
	
	public List<TermsDTD> findAllTerms(){
		return dao.selectAllTerms();
	}
	
	public void modifyTerms(TermsDTD dto) {
		dao.updateTerms(dto);
	}
	
	public void deleteTerms(int no) {
		dao.deleteTerms(no);
	}
	
	
}
