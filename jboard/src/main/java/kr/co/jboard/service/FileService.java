package kr.co.jboard.service;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import kr.co.jboard.dao.ArticleDAO;
import kr.co.jboard.dao.FileDAO;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.FileDTO;

public enum FileService {

	INSTANCE;
	private FileDAO dao = FileDAO.getInstance();
	
	public void registerFile(FileDTO dto) {
		dao.insertFile(dto);
	}
	
	public FileDTO findFile(int fno) {
		return dao.selectFile(fno);
	}
	
	public List<FileDTO> findAllFile(){
		return dao.selectAllFile();
	}
	
	public void modifyFile(FileDTO dto) {
		dao.updateFile(dto);
	}
	
	public void deleteFile(int no) {
		dao.deleteFile(no);
	}
	
	// ���� ���ε� ����Ͻ� �޼���
	public void uploadFile(HttpServletRequest req) {
		
		// ���ε� ��� ���ϱ�
		ServletContext ctx = req.getServletContext();
		String uploadPath = ctx.getRealPath("/uploads");
		
		// ���� ���ε� ���͸��� �������� ������ ���͸� ����
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			// ÷������ ��ü �������� 
			Collection<Part> parts = req.getParts();
			
			for(Part part : parts) {
				
				// ���ϸ� ����
				String oName = part.getSubmittedFileName();
				
				if(oName != null && !oName.isEmpty()) {
					// ���� ���ϸ� ����
					int idx = oName.lastIndexOf(".");
					String ext = oName.substring(idx);
					String sName = UUID.randomUUID().toString() + ext;
					
					// ���� ����
					part.write(uploadPath + File.separator + sName );					
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// ���� �ٿ�ε� ����Ͻ� �޼���
	
	
}
