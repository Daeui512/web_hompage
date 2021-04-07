package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_auth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	
    public LoginServlet() {
    	dao = MemberDAOimple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		response.sendRedirect("/Homepage/login.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		memberSelect(request, response);	
	}

	private void memberSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		MemberVO vo = dao.select(userid, password);
		System.out.println(vo);
		
		PrintWriter out = response.getWriter();

		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", vo.getUserid());
			session.setAttribute("password", vo.getPassword());
			session.setMaxInactiveInterval(60);
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('로그인 성공!!')</script>");
			out.print("<script>location.href='login_result.jsp';</script>");
			out.print("</head>");
		} else {
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('아이디/비밀번호가 잘못되었습니다.')</script>");
			out.print("<script>location.href='login.jsp';</script>");
			out.print("</head>");
		}
	}
}
