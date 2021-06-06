package com.dev.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;


public class MemberDeleteController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");

		MemberService service = MemberService.getInstance();
		service.memberDelete(id);

		HttpUtill.forward(request, response, "/result/memberDeleteOutput.jsp");
 }
}
