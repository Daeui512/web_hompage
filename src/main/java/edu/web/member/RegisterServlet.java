package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       
    public RegisterServlet() {
    	dao = MemberDAOimple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		response.sendRedirect("/Homepage/member_register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		memberInsert(request, response);
	}

	private void memberInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		if(result == 1) { // 회원가입 성공
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('등록 성공! 로그인해주세요.')</script>");
			out.print("<script>location.href='login.jsp';</script>");
			out.print("</head>");
		}
	}

}
