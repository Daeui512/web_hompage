package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;
	
    public UpdateServlet() {
    	dao = MemberDAOimple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		response.sendRedirect("/Homepage/login.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		memberUpdate(request, response);
	}

	private void memberUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce"); 
		
		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		
		int result = dao.update(vo);
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('회원정보 수정이 완료되었습니다, 로그인 페이지로 돌아갑니다.')</script>");
			out.print("<script>location.href='login.jsp';</script>");
			out.print("</head>");
		}
	}

}
