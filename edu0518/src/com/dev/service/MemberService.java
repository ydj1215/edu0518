package com.dev.service;
import java.util.ArrayList;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {
	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();
	private MemberService () {}
	public static MemberService getInstance()
	{
		return service;
	}
	public void memberInsert(MemberVO member)
	{
		dao.memberInsert(member);
	}
	public MemberVO memberSearch(String id)
	{
		MemberVO member = dao.memberSearch(id);
		return member;
	}
	public void memberUpdate(MemberVO member)
	{
		dao.memberUpdate(member);
	}
	public ArrayList<MemberVO> memberListAll() {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> list = dao.memberListAll();
		return list;
	}

	public void memberDelete(String id) {
		// TODO Auto-generated method stub
		dao.memberDelete(id);
	}
}
