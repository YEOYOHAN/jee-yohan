package com.bank.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.web.command.Sender;
import com.bank.web.command.Receiver;
import com.bank.web.domains.CustomerBean;
import com.bank.web.services.MemberService;
import com.bank.web.servicesImpls.MemberServiceImpl;


@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		Receiver.init(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction()==null) {
			Receiver.cmd.setPage();
		}
		switch (Receiver.cmd.getAction()) {
		case "join":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			param.setCredit(credit);
			param.setId(id);
			param.setName(name);
			param.setPw(pw);
			param.setSsn(ssn);
			service = new MemberServiceImpl();
			service.join(param);
			System.out.println(param.toString());
			Receiver.cmd.setPage("login");
			break;
		case "login":
			CustomerBean cust = new CustomerBean();
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			param.setId(id);
			param.setPw(pw);
			cust = service.login(param);
			if(cust == null) {
				
				Receiver.cmd.setPage("login");
			}else {
				Receiver.cmd.setPage("mypage");
			}
			request.setAttribute("customer", cust);
			break;
		case "existID":
			break;
		case "mypage":
			break;
		}
		Sender.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
