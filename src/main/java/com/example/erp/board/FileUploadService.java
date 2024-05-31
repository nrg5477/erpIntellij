package com.example.erp.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.erp.dto.BoardFileDTO;

@Service
public class FileUploadService {
	//파일 업로드를 수행하는 메소드 - 파일업로드를 하기 위해서 List<MultipartFile> 객체와 실제 업로드할 위치를 매개변수로 전달 받아 사용
	//업로드되는 파일의 정보를 List<BoardFileDTO>로 만들어서 반환
	public List<BoardFileDTO> uploadFiles(List<MultipartFile> multipartFiles, String path) throws IllegalStateException, IOException {
		//게시글 등록
		List<BoardFileDTO> filedtolist = new ArrayList<BoardFileDTO>();
		for(MultipartFile multipartFile : multipartFiles) {
			if(!multipartFile.isEmpty()) {
				//파일명
				String storeFilename = uploadFile(multipartFile,path);
				filedtolist.add(new BoardFileDTO(UUID.randomUUID().toString(),null,multipartFile.getOriginalFilename(),storeFilename));
			}
		}
		return filedtolist;
	}
	
	public String uploadFile(MultipartFile multipartFile, String path) throws IllegalStateException, IOException {
		//회원등록
	  
		String storeFilename="";
	    
	    if (!multipartFile.isEmpty()) {
	    	System.out.println("널이 아니게 들어옴");
	        String originalFilename = multipartFile.getOriginalFilename();
	        storeFilename = createStoreFilename(originalFilename);
	        multipartFile.transferTo(new File(path + File.separator + storeFilename));
	        
	        return storeFilename;
	    } else {
	      
	    	System.out.println("널로들어옴");
	        return null;
	    }
	}
	
	
	//UUID를 이용해서 파일명을 변경해서 리턴
	private String createStoreFilename(String originalFilename) {
		int position = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(position+1); //확장자명 추출
		String uuid = UUID.randomUUID().toString();
		return uuid+"."+ext;
	}
}
