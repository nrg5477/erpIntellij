package com.example.erp.member;

import java.util.List;

import com.example.erp.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	
	@Autowired
	public MemberServiceImpl(MemberDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(MemberDTO user) {
		return dao.insert(user);
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> memberlist = dao.getMemberList();
		return memberlist;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> search(String column, String search, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	//DB에서 조회한 데이터를 가공
	//뷰이름을 수정
	// menu/it_menu.jsp => menu/it
	@Override
	public MemberDTO login(MemberDTO loginUser) {
		//loginUser는 사용자가 입력한 값이 저장된 dto (request용 DTO)이고,
		//user는 디비인증 결과가 저장된 dto(response용 DTO)
		MemberDTO user = dao.login(loginUser);
		System.out.println("서비스=>"+user);
		//db에서 가져온 값에서 menupath를 가공해서 뷰의 이름으로 menupath에 다시 셋팅
		if(user!=null) {
			String menupath = user.getMenupath();
			menupath = menupath.substring(menupath.indexOf("/")+1, menupath.indexOf("_"));
			user.setMenupath(menupath);//잘라낸 문자열이 뷰의 이름이므로 다시 setter메소드를 호출해서 저장한다.
		}
		System.out.println("+++++++++=>"+user);
		return user;
	}

}
