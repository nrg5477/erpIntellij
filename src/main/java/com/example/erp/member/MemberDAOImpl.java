package com.example.erp.member;

import java.util.List;

import com.example.erp.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	SqlSession sqlSessionTemplate;
	
	@Autowired
	public MemberDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<MemberDTO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDTO user) {
		System.out.println("memberdaoimple"+user);
		return sqlSessionTemplate.insert("com.multi.erp.member.insert", user);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		return sqlSessionTemplate.selectList("com.multi.erp.member.selectall");
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

	@Override
	public MemberDTO login(MemberDTO loginUser) {
		return sqlSessionTemplate.selectOne("com.multi.erp.member.login", loginUser);
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
