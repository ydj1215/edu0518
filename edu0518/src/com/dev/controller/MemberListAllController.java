package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberListAllController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService service = MemberService.getInstance(); //본인안에 본인의 생성자로 하나만 객체를 만들어서 그 객체를 반환하는 함수
		ArrayList<MemberVO> list = service.memberListAll();
	
		request.setAttribute("list", list);
		HttpUtill.forward(request, response, "/result/memberListAllOutput.jsp"); //갈곳의 주소
	}

}
