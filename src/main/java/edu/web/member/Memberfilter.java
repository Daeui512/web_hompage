package edu.web.member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/Memberfilter")
public class Memberfilter implements Filter {

	public Memberfilter() {
	    
    }
    // init() : 필터가 시작할 때 호출
    public void init(FilterConfig fConfig) throws ServletException {
    	
    }
    // doFilter() : 필터를 사용할 떄 마다 호출
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//클라이언트로부터 IP얻기
		String ipAddress = request.getRemoteAddr();
		
		//현재 시간과 IP주소 출력
		System.out.println("ID : " + ipAddress + ", Time : " + new Date().toString());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}
	// destroy() : 필터가 종료될 때 호출
	public void destroy() {

	}
}
