package kr.co.jboard.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.co.jboard.dao.ArticleDAO;
import kr.co.jboard.dao.FileDAO;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.FileDTO;

public enum FileService {

	INSTANCE;
	private FileDAO dao = FileDAO.getInstance();
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	public void insertFile(FileDTO dto) {
		
	}
	
	
	public void registerFile(FileDTO dto) {
		dao.insertFile(dto);
	}
	
	public FileDTO findFile(String fno) {
		return dao.selectFile(fno);
	}
	
	public List<FileDTO> findAllFile(){
		return dao.selectAllFile();
	}
	
	public void modifyFile(FileDTO dto) {
		dao.updateFile(dto);
	}
	
	public void deleteFile(HttpServletRequest req, List<String> snames) {
		
		String no = req.getParameter("no");
		
		// ���͸� ���� ����
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/uploads");
		
		for(String sname : snames ) {
			File target = new File(path + File.separator + sname); // ��� + ������ + ���ϸ�	
			target.delete();
					
		}
		// DB File ������ ����
		dao.deleteFile(no);
		
	}
	
	public void downloadCountUp(String fno) {
		dao.updateFileDownloadCount(fno);
	}
	

	public List<String> findFileByAno(String no) {
		return dao.selectFileByAno(no);
	}

	
	// ���� ���ε� ����Ͻ� �޼���
	public List<FileDTO> uploadFile(HttpServletRequest req) {
		
		List<FileDTO> files = new ArrayList<>();
		
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
					
					// FileDTO ��ü ����
					FileDTO dto = new FileDTO();
					dto.setoName(oName);
					dto.setsName(sName);				
				
					files.add(dto);
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return files;
		
	}


	// ���� �ٿ�ε� 
	public void downloadFile(HttpServletRequest req, HttpServletResponse resp) {
		
		// ���� ������ ���� ������ü ��������
		FileDTO fileDTO = (FileDTO)req.getAttribute("fileDTO");
		
		// response ���� ��Ʈ�� �۾�
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/uploads");
		File target = new File(path + File.separator + fileDTO.getsName()); // ��� + ������ + ���ϸ�

				
		try {
			// response ���� �ٿ�ε� ��� ����
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileDTO.getoName(), "utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(target));
			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
			
			// ���� ����
			bis.transferTo(bos);
			
			bos.flush();
			bos.close();
			bis.close();		
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	
	
}
